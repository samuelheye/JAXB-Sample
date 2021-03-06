package com.javapapers.xml.jaxb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBUnmarshalSample {

	public static void main(String[] args) {
		try {

			JAXBContext jaxbContext = JAXBContext
					.newInstance("com.javapapers.xml.jaxb");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<?> zoo = (JAXBElement<?>) unmarshaller
					.unmarshal(new FileInputStream("zoo.xml"));
			ZooInfo zooInfo = (ZooInfo) zoo.getValue();

			System.out.println("Zoo Name: " + zooInfo.getZooName());
			System.out.println("Zoo Id: " + zooInfo.getZooId());

			Animals animals = zooInfo.getAnimals();
			List<Animals.Animal> animalsList = animals.getAnimal();

			for (Animals.Animal animal : animalsList) {
				System.out.println("\t" + animal.getAnimalName());
				System.out.println("\t\t" + animal.getAnimalType());
			}

		} catch (JAXBException je) {
			je.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
