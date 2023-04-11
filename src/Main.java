import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        SinglyLinkedList primesList = new SinglyLinkedList();
        SinglyLinkedList primesWith3List = new SinglyLinkedList();

        // Populate the main linked list with prime numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            if (PrimeChecker.isPrime(i)) {
                primesList.addLast(i);
            }
        }

        // Iterate over the main linked list to find numbers with 3
        Node current = primesList.getHead();
        while (current != null) {
            int num = current.getData();
            if (String.valueOf(num).contains("3")) {
                primesWith3List.addLast(num);
                primesList.remove(num);
            }
            current = current.getNext();
        }

        // Calculate the sum of the numbers in the linked list for numbers with 3
        int sum = primesWith3List.sum();

        // Print the list of prime numbers that have 3 and their sum
        System.out.println("The prime numbers from 0 to " + n + " that have 3 are: " + primesWith3List);
        System.out.println("The sum of these numbers is: " + sum);
    }
}
