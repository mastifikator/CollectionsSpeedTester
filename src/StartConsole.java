import Randomizer.ArrayListsToMap;
import Randomizer.RandomArrayListGenerator;
import TestListCollections.SpeedArrayList;
import TestListCollections.SpeedLinkedList;
import TestListCollections.SpeedVector;
import TestMapCollections.SpeedHashMap;
import TestMapCollections.SpeedLinkedHashMap;
import TestMapCollections.SpeedTreeMap;
import TestSetCollections.SpeedHashSet;
import TestSetCollections.SpeedLinkedHashSet;
import TestSetCollections.SpeedTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StartConsole {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String mainMenu = null;
        String secondMenu = null;
        String choice = null;
        String typeVariable1 = null;
        String typeVariable2 = null;
        String countOperation = null;
        String countAdd = null;
        String countGet = null;
        String countDel = null;

        boolean newInput = true;
        while(newInput) {
            mainMenu = null;
            secondMenu = null;
            choice = null;
            typeVariable1 = null;
            typeVariable2 = null;
            countOperation = null;
            countAdd = null;
            countGet = null;
            countDel = null;

            boolean nextStep = false;
            while (!nextStep) {
                System.out.println("################### CollectionsSpeedTester #####################");
                System.out.println("#################### Выбор типа коллекции #####################");
                System.out.println("1. List");
                System.out.println("2. Set");
                System.out.println("3. Map");
                System.out.print("Выберите тип коллекций который будем тестировать (1 - 3):");

                mainMenu = reader.readLine();
                if (mainMenu.equals("1") || mainMenu.equals("2") || mainMenu.equals("3")) nextStep = true;
            }

            nextStep = false;
            while (!nextStep) {
                System.out.println("################### CollectionsSpeedTester #####################");
                if (mainMenu.equals("1")) {
                    System.out.println("#################### Выбор типа List #####################");
                    System.out.println("1. ArrayList");
                    System.out.println("2. LinkedList");
                    System.out.println("3. Vector");
                    System.out.print("Выберите тип List который будем тестировать (1 - 3):");
                    secondMenu = reader.readLine();
                } else if (mainMenu.equals("2")) {
                    System.out.println("#################### Выбор типа Set #####################");
                    System.out.println("1. HashSet");
                    System.out.println("2. LinkedHashSet");
                    System.out.println("3. TreeSet");
                    System.out.print("Выберите тип Set который будем тестировать (1 - 3):");
                    secondMenu = reader.readLine();
                } else if (mainMenu.equals("3")) {
                    System.out.println("#################### Выбор типа Map #####################");
                    System.out.println("1. HashMap");
                    System.out.println("2. LinkedHashMap");
                    System.out.println("3. TreeMap");
                    System.out.print("Выберите тип Map который будем тестировать (1 - 3):");
                    secondMenu = reader.readLine();
                }
                if (secondMenu.equals("1") || secondMenu.equals("2") || secondMenu.equals("3")) nextStep = true;
            }

            switch (mainMenu) {
                case ("1"):
                    switch (secondMenu) {
                        case ("1"):
                            choice = "ArrayList";
                            break;
                        case ("2"):
                            choice = "LinkedList";
                            break;
                        case ("3"):
                            choice = "Vector";
                            break;
                    }
                case ("2"):
                    switch (secondMenu) {
                        case ("1"):
                            choice = "HashSet";
                            break;
                        case ("2"):
                            choice = "LinkedHashSet";
                            break;
                        case ("3"):
                            choice = "TreeSet";
                            break;
                    }
                case ("3"):
                    switch (secondMenu) {
                        case ("1"):
                            choice = "HashMap";
                            break;
                        case ("2"):
                            choice = "LinkedHashMap";
                            break;
                        case ("3"):
                            choice = "TreeMap";
                            break;
                    }
            }

            nextStep = false;
            while (!nextStep) {
                System.out.println("\n################### CollectionsSpeedTester #####################");
                System.out.println("#################### Выбор типа переменной #####################");
                System.out.println("Поддерживаются: Integer, Float, Long, Double, String, Character, Boolean, Byte, Date, TestObject");
                if (mainMenu.equals("3")) {
                    System.out.print("Введите тип переменной ключа (Key) с которым будем тестироват " + choice + ":");
                    typeVariable1 = reader.readLine();
                    System.out.print("Введите тип переменной Значения (Value) с которым будем тестировать " + choice + ":");
                    typeVariable2 = reader.readLine();

                    boolean var1 = false;
                    switch (typeVariable1) {
                        case ("Integer"):
                        case ("Float"):
                        case ("Long"):
                        case ("Double"):
                        case ("String"):
                        case ("Character"):
                        case ("Boolean"):
                        case ("Byte"):
                        case ("Date"):
                        case ("TestObject"):
                            var1 = true;
                            break;
                    }

                    boolean var2 = false;
                    switch (typeVariable2) {
                        case ("Integer"):
                        case ("Float"):
                        case ("Long"):
                        case ("Double"):
                        case ("String"):
                        case ("Character"):
                        case ("Boolean"):
                        case ("Byte"):
                        case ("Date"):
                        case ("TestObject"):
                            var2 = true;
                            break;
                    }

                    if (var1 && var2) nextStep = true;
                } else {
                    System.out.print("Введите тип переменной с которым будем тестировать " + choice + ":");
                    typeVariable1 = reader.readLine();

                    switch (typeVariable1) {
                        case ("Integer"):
                        case ("Float"):
                        case ("Long"):
                        case ("Double"):
                        case ("String"):
                        case ("Character"):
                        case ("Boolean"):
                        case ("Byte"):
                        case ("Date"):
                        case ("TestObject"):
                            nextStep = true;
                            break;
                    }
                }
            }

            nextStep = false;
            while (!nextStep) {
                System.out.println("\n################### CollectionsSpeedTester #####################");
                System.out.println("################# Выбор колличества элементов ##################");
                System.out.print("Введите колличество элементов (от 1 до 1kk) в изначальном " + choice + ":");
                countOperation = reader.readLine();
                try {
                    if (Integer.parseInt(countOperation) > 1 && Integer.parseInt(countOperation) < 1_000_000)
                        nextStep = true;
                } catch (NumberFormatException e) {e.printStackTrace();}
            }

            nextStep = false;
            while (!nextStep) {
                System.out.println("\n################### CollectionsSpeedTester #####################");
                System.out.println("########## Выбор колличества элементов при добавлении ##########");
                System.out.print("Введите колличество добавляемых элементов (от 1 до 1kk):");
                countAdd = reader.readLine();
                try {
                    if (Integer.parseInt(countAdd) > 1 && Integer.parseInt(countAdd) < 1_000_000)
                        nextStep = true;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            nextStep = false;
            while (!nextStep) {
                System.out.println("\n################### CollectionsSpeedTester #####################");
                System.out.println("########## Выбор колличества элементов при получении ##########");
                System.out.print("Введите колличество добавляемых элементов (от 1 до 1kk):");
                countGet = reader.readLine();
                try {
                    if (Integer.parseInt(countGet) > 1 && Integer.parseInt(countGet) < 1_000_000)
                        nextStep = true;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            nextStep = false;
            while (!nextStep) {
                System.out.println("\n################### CollectionsSpeedTester #####################");
                System.out.println("########## Выбор колличества элементов при удалении ##########");
                System.out.print("Введите колличество удаляемых элементов (от 1 до 1kk):");
                countDel = reader.readLine();
                try {
                    if (Integer.parseInt(countDel) > 1 && Integer.parseInt(countDel) < 1_000_000)
                        nextStep = true;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            nextStep = false;
            while (!nextStep) {
                System.out.println("\n################### CollectionsSpeedTester #####################");
                System.out.println("\n################### Подтверждение #####################");
                System.out.println("Начинаем тестировать:     " + choice);
                if (mainMenu.equals("3")) {
                    System.out.println("Тип ключа:                " + typeVariable1);
                    System.out.println("Тип значений:             " + typeVariable2);
                } else {
                    System.out.println("Тип элементов:           " + typeVariable1);
                }
                System.out.println("Изначальное колличество: " + countOperation);
                System.out.println("Добавляемое колличество: " + countAdd);
                System.out.println("Получаемое колличество:  " + countGet);
                System.out.println("Удаляемое колличество:   " + countDel);

                System.out.print("Введите Да чтобы начать или Нет чтобы переопределить выбор: ");
                String confirm = reader.readLine();
                if (confirm.equals("Да")) {
                    newInput = false;
                    nextStep = true;
                } else if (confirm.equals("Нет")) {
                    nextStep = true;
                }
            }
        }

        switch(choice){
            case("ArrayList") : {
                RandomArrayListGenerator random =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countOperation), true);
                RandomArrayListGenerator randomAdd =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countAdd), true);
                SpeedArrayList test = new SpeedArrayList(random.getList());
                test.add(randomAdd.getList());
                test.get(Integer.parseInt(countGet));
                test.remove(Integer.parseInt(countDel));
            }
            case("LinkedList") : {
                RandomArrayListGenerator random =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countOperation), true);
                RandomArrayListGenerator randomAdd =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countAdd), true);
                SpeedLinkedList test = new SpeedLinkedList(new LinkedList(random.getList()));
                test.add(randomAdd.getList());
                test.get(Integer.parseInt(countGet));
                test.remove(Integer.parseInt(countDel));
            }
            case("Vector") : {
                RandomArrayListGenerator random =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countOperation), true);
                RandomArrayListGenerator randomAdd =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countAdd), true);
                SpeedVector test = new SpeedVector(new Vector(random.getList()));
                test.add(randomAdd.getList());
                test.get(Integer.parseInt(countGet));
                test.remove(Integer.parseInt(countDel));
            }
            case("HashSet") : {
                RandomArrayListGenerator random =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countOperation), true);
                RandomArrayListGenerator randomAdd =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countAdd), true);
                SpeedHashSet test = new SpeedHashSet(new HashSet(random.getList()));
                test.add(new HashSet(randomAdd.getList()));
                test.get(Integer.parseInt(countGet));
                test.remove(Integer.parseInt(countDel));
            }
            case("LinkedHashSet") : {
                RandomArrayListGenerator random =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countOperation), true);
                RandomArrayListGenerator randomAdd =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countAdd), true);
                SpeedLinkedHashSet test = new SpeedLinkedHashSet(new LinkedHashSet(random.getList()));
                test.add(new LinkedHashSet(randomAdd.getList()));
                test.get(Integer.parseInt(countGet));
                test.remove(Integer.parseInt(countDel));
            }
            case("TreeSet") : {
                RandomArrayListGenerator random =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countOperation), true);
                RandomArrayListGenerator randomAdd =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countAdd), true);
                SpeedTreeSet test = new SpeedTreeSet(new TreeSet(random.getList()));
                test.add(new TreeSet(randomAdd.getList()));
                test.get(Integer.parseInt(countGet));
                test.remove(Integer.parseInt(countDel));
            }
            case("HashMap") : {
                RandomArrayListGenerator randomKey =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countOperation), true);
                RandomArrayListGenerator randomValue =  new RandomArrayListGenerator(typeVariable2, Integer.parseInt(countOperation), true);
                HashMap random = ArrayListsToMap.merge(randomKey.getList(), randomValue.getList());

                RandomArrayListGenerator randomAddKey =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countAdd), true);
                RandomArrayListGenerator randomAddValue =  new RandomArrayListGenerator(typeVariable2, Integer.parseInt(countAdd), true);
                HashMap randomAdd = ArrayListsToMap.merge(randomAddKey.getList(), randomAddValue.getList());

                SpeedHashMap test = new SpeedHashMap(random);
                test.add(randomAdd);
                test.get(Integer.parseInt(countGet));
                test.remove(Integer.parseInt(countDel));
            }
            case("LinkedHashMap") : {
                RandomArrayListGenerator randomKey =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countOperation), true);
                RandomArrayListGenerator randomValue =  new RandomArrayListGenerator(typeVariable2, Integer.parseInt(countOperation), true);
                LinkedHashMap random = new LinkedHashMap(ArrayListsToMap.merge(randomKey.getList(), randomValue.getList()));

                RandomArrayListGenerator randomAddKey =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countAdd), true);
                RandomArrayListGenerator randomAddValue =  new RandomArrayListGenerator(typeVariable2, Integer.parseInt(countAdd), true);
                LinkedHashMap randomAdd = new LinkedHashMap(ArrayListsToMap.merge(randomAddKey.getList(), randomAddValue.getList()));

                SpeedLinkedHashMap test = new SpeedLinkedHashMap(random);
                test.add(randomAdd);
                test.get(Integer.parseInt(countGet));
                test.remove(Integer.parseInt(countDel));
            }
            case("TreeMap") : {
                RandomArrayListGenerator randomKey =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countOperation), true);
                RandomArrayListGenerator randomValue =  new RandomArrayListGenerator(typeVariable2, Integer.parseInt(countOperation), true);
                TreeMap random = new TreeMap(ArrayListsToMap.merge(randomKey.getList(), randomValue.getList()));

                RandomArrayListGenerator randomAddKey =  new RandomArrayListGenerator(typeVariable1, Integer.parseInt(countAdd), true);
                RandomArrayListGenerator randomAddValue =  new RandomArrayListGenerator(typeVariable2, Integer.parseInt(countAdd), true);
                HashMap randomAdd = ArrayListsToMap.merge(randomAddKey.getList(), randomAddValue.getList());

                SpeedTreeMap test = new SpeedTreeMap(random);
                test.add(randomAdd);
                test.get(Integer.parseInt(countGet));
                test.remove(Integer.parseInt(countDel));
            }
        }
    }
}
