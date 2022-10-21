package com.raiseup.exploreApi;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raiseup.exploreApi.model.Difficulty;
import com.raiseup.exploreApi.model.Region;
import com.raiseup.exploreApi.model.Tour;
import com.raiseup.exploreApi.model.TourPackage;
import com.raiseup.exploreApi.service.TourPackageService;
import com.raiseup.exploreApi.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ExploreApiApplication implements CommandLineRunner {
	private final TourPackageService tourPackageService;
	private final TourService tourService;

	public static void main(String[] args) {
		SpringApplication.run(ExploreApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(tourPackageService.tourPackageCount()==0){
			init();
		}
	}

	private void init() throws IOException {
		tourPackageService.createTourPackage(new TourPackage("BC", "Backpack Cal"));
		tourPackageService.createTourPackage(new TourPackage("CC", "California Calm"));
		tourPackageService.createTourPackage(new TourPackage("CH", "California Hot springs"));
		tourPackageService.createTourPackage(new TourPackage("CY", "Cycle California"));
		tourPackageService.createTourPackage(new TourPackage("DS", "From Desert to Sea"));
		tourPackageService.createTourPackage(new TourPackage("KC", "Kids California"));
		tourPackageService.createTourPackage(new TourPackage("NW", "Nature Watch"));
		tourPackageService.createTourPackage(new TourPackage("SC", "Snowboard Cali"));
		tourPackageService.createTourPackage(new TourPackage("TC", "Taste of California"));
		TourFromFile.importTours().forEach(t-> tourService.createTour(new Tour(
				t.title,
				t.description,
				t.blurb,
				BigDecimal.valueOf(Long.parseLong(t.price)),
				t.length,
				t.bullets,
				t.keywords,
				tourPackageService.findByName(t.packageType).get(),
				Difficulty.findByLabel(t.difficulty),
				Region.findByLabel(t.region))));
		System.out.println("Number of tours =" + tourService.tourCount());
	}

	static class TourFromFile {
		//attributes as listed in the .json file
		private String packageType, title, description, blurb, price, length, bullets, keywords,  difficulty, region;

		/**
		 * Open the ExploreCalifornia.json, unmarshal every entry into a TourFromFile Object.
		 *
		 * @return a List of TourFromFile objects.
		 * @throws IOException if ObjectMapper unable to open file.
		 */
		static List<TourFromFile> importTours() throws IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
					readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"),new TypeReference<List<TourFromFile>>(){});
		}
	}

}

