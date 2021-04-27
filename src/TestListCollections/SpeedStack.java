package TestListCollections;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class SpeedStack {

    private Stack stack;
    private final String COLLECTION_TYPE = "Stack";

    public SpeedStack(Stack stack) {
        this.stack = stack;
    }

    public void add(List addedList) {

        System.out.printf("\nТестируем скорость операций добавления элементов в %s \n", COLLECTION_TYPE);
        System.out.println("--------------------------------------------------");

        AddToList.addToBegin(addedList, stack, COLLECTION_TYPE);
        AddToList.addToEnd(addedList, stack, COLLECTION_TYPE);
        AddToList.addToMiddle(addedList, stack, COLLECTION_TYPE);
    }

    public void get(int countOperationsGet) {
        System.out.printf("\nТестируем скорость операций получения элементов из %s \n", COLLECTION_TYPE);
        System.out.println("--------------------------------------------------");

        GetOfList.get(countOperationsGet, stack, COLLECTION_TYPE);
    }

    public void remove(int countOperationsRemove) {
        System.out.printf("\nТестируем скорость операций удаления элементов из %s \n", COLLECTION_TYPE);
        System.out.println("--------------------------------------------------");

        RemoveOfList.remove(countOperationsRemove, stack, COLLECTION_TYPE);
    }

}