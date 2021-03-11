import java.util.ArrayList;
import java.util.List;

import controller.AnimalHelper;
import controller.CaretakerHelper;
import controller.ZooHelper;
import model.Animal;
import model.Caretaker;
import model.Zoo;

public class Tester {
	public static void main(String[] args)
	{
		/*Zoo newzoo = new Zoo("Henry Doorly");
		Caretaker care = new Caretaker("Jim", "Jam");
		Animal aminal = new Animal("Tony the Tiger", 23);
		List<Animal> animals = new ArrayList<>();
		animals.add(aminal);
		List<Caretaker> caretakers = new ArrayList<>();
		caretakers.add(care);
		care.setAnimalList(animals);
		newzoo.setCaretakerList(caretakers);
		ZooHelper help = new ZooHelper();
		help.insertZoo(newzoo);
		List<Zoo> zoos = help.getZoos();
		for (Zoo zoo: zoos)
			{
				System.out.println(zoo.toString());
			}*/
		ZooHelper zooHelp = new ZooHelper();
		AnimalHelper animalHelp = new AnimalHelper();
		CaretakerHelper help = new CaretakerHelper();
		//help.deleteCaretaker(1);
		Caretaker care = new Caretaker("Jim", "Jam");
		List<Caretaker> caretakers = new ArrayList<>();
		caretakers.add(care);
		Zoo zooer = zooHelp.searchId(3);
		zooer.setCaretakerList(caretakers);
		zooHelp.updateZoo(zooer);
		
		
		List<Zoo> zoos = zooHelp.getZoos();
		for (Zoo zoo : zoos)
		{
			System.out.println(zoo.toString());
		}
		
	}
}