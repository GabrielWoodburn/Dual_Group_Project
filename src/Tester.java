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
		
		
		CaretakerHelper care = new CaretakerHelper();
		Caretaker careTake = care.searchId(4);
		List<Animal> list = careTake.getAnimalList();
		Animal an = new Animal("Tiger", 56);
		list.add(an);
		careTake.setAnimalList(list);
		List<Zoo> zoos = zooHelp.getZoos();
		for (Zoo zoo : zoos)
		{
			System.out.println(zoo.toString());
		}
		
	}
}