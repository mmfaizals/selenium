package com.css.training.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class TestAutomationDataProvider {

	@DataProvider(name="dataForBiography")
	public static Iterator<BiographySearchIO[]> prepareDataForBiography(){
		ArrayList<BiographySearchIO[]> listOfParams= new ArrayList<BiographySearchIO[]>();
		BiographySearchIO d1= new BiographySearchIO();
		d1.qText="Yoona";
		d1.wikiLink="Im Yoona - Wiki";
		d1.born="May 30, 1990";
		BiographySearchIO[] params = {d1};
		listOfParams.add(params);
		return listOfParams.iterator();
	}
	
	@DataProvider(name="dataForBiographyFromXls")
	public static Iterator<BiographySearchIO[]> prepareDataForBiographyFromXls(){
		ArrayList<BiographySearchIO[]> listOfParams= new ArrayList<BiographySearchIO[]>();
		List<BiographySearchIO> data=new ReadExcel().getDataFromExcel();
		for(BiographySearchIO it:data){
		BiographySearchIO[] params = {it};
		listOfParams.add(params);
		}
		return listOfParams.iterator();
	}
}
