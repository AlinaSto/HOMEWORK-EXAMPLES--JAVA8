package HomeworkSesiunea17;

import LambdaPerson.Person;

import java.util.*;
import java.util.stream.Collectors;

public class STREAM_EXAMPLES {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(12);
        list1.add(23);
        list1.add(45);
        list1.add(6);
        //todo 1.
        System.out.println(findNumbersBiggerThan(list1, 15));
        //todo 2.
        List<String> programmingLanguages = Arrays.asList("Java", "", "scala", "Kotlin", "", "clojure");
        //todo 3.
        List<demo.streams.helperclasses.Person> list = new ArrayList<>();
        list.add(new demo.streams.helperclasses.Person("Dave", 23, "USA"));
        list.add(new demo.streams.helperclasses.Person("Joe", 18, "USA"));
        list.add(new demo.streams.helperclasses.Person("Ryan", 54, "USA"));
        list.add(new demo.streams.helperclasses.Person("Iyan", 5, "USA"));
        list.add(new demo.streams.helperclasses.Person("Ray", 63, "USA"));
        //todo 4.

        List<String> companies = Arrays.asList("Google", "Amazon", "GOOGLE");
//todo 8-9 divisible numbers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(88);
        numbers.add(5);
        numbers.add(7);
        numbers.add(4);
        numbers.add(9);
        System.out.println(numbers);

        List<Integer> numbersList2 = List.of(-20, -40, -60, -5,8);
        System.out.println("-----------------------------------");
        System.out.println(returnPositiveNumbers(numbersList2));
        System.out.println(returnPositiveNumbersUsingNormalMethod(numbersList2));
    }

    //todo 1.
    //returneaza numerele din lista care sunt mai mari decat X

    public static List<Integer> findNumbersBiggerThan(List<Integer> list, int x) {
        return list.stream()
                .filter(number -> number > x)
                .collect(Collectors.toList()); //colectam intr o lista

    }

    //todo 2.
    //2. printeaza cate string-uri din lista care incep cu litera mare si care nu sunt goale

    public static long countLanguages(List<String> programmingLanguages) {
        long count2 = programmingLanguages.stream()
                .filter(language -> !language.isEmpty())
                .filter(language -> Character.isUpperCase(language.charAt(0)))
                .count();
        return count2;
    }
    //todo 3.

    //3. printeaza care sunt persoanele active (cu varsta mai mare decat 18 si mai mica decat 60 de ani)
    public static List<demo.streams.helperclasses.Person> activePersons(List<demo.streams.helperclasses.Person> list) {
        list.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 60)
                .forEach(person -> System.out.println(person));
        return list;
    }

    //todo 4.

    public static void companiesToUpperCase(List<String> companies) {
        companies.stream()
                .map(company -> company.toUpperCase()) //parcurge stream ul adica lista si inlocuieste fiecare elem din dtream cu ce ii dau in functie
                .peek(x -> System.out.println(x)) //debugger
                .distinct() //genereaza alt stream format din dtreamul generat din primul dar unice
                .peek(x -> System.out.println(x))
                .forEach(company -> System.out.println(company));//operatie terminala
    }

    //todo 5 ANY,ALLMATCH, NONEMATCH.
    public static boolean isAnyPersonFrom(String countryName, List<demo.streams.helperclasses.Person> personList) {
        return personList.stream()
                .anyMatch(person -> person.getCountry().equals(countryName));

        //     .allMatch(person -> person.getCountry().equals(country));

        //     .noneMatch(person -> person.getCountry().equals(country));
    }

    // todo 6. REDUCTION OPERATIONAL
    //1. printeaza maximul din lista de numere
    List<Integer> transactions = List.of(20, 40, -60, 5);

    public static Integer printMaximumNumber(List<Integer> transactions) {
        Optional<Integer> optionalMax = transactions.stream()
                .max((number1, number2) -> number1.compareTo(number2));
        System.out.println(optionalMax.orElse(0));
        //2. printeaza suma numerelor din lista
//        in sum intra prima valoare si in transaction intra a doua
        Optional<Integer> optionalSum = (transactions.stream()
                .reduce((sum, transaction) -> sum + transaction));
        if (optionalSum.isPresent()) {
            System.out.println(optionalSum.get());
        }
        // todo 7. OPERATIONAL,

        List<demo.streams.helperclasses.Employee> employeeList = new ArrayList<>();
        employeeList.add(new demo.streams.helperclasses.Employee("Ben", 63, 25000, "India"));
        employeeList.add(new demo.streams.helperclasses.Employee("Dave", 34, 56000, "Bhutan"));
        employeeList.add(new demo.streams.helperclasses.Employee("Jodi", 43, 67000, "China"));
        employeeList.add(new demo.streams.helperclasses.Employee("Ryan", 53, 54000, "Libya"));
//        3. printeaza suma salariilor angajatilor din lista
//
//        1 stream din lista de angajati
//        2. mapam lista de angajati la lista de salarii
//        3.folosim reduce sa facem suma salariilor
        Optional<Integer> salaryCounter = employeeList.stream()
                .map(employee -> employee.getSalary())
                .reduce((sum2, transaction2) -> sum2 + transaction2);
        System.out.println(salaryCounter.orElse(0));


        // todo 8.

        List<Person> personList1 = new ArrayList<>();
        personList1.add(new Person("Gogu", 41));
        personList1.add(new Person("Ana", 12));
        personList1.add(new Person("Anael", 8));
        personList1.add(new Person("Ion", 42));

// Sorteaza o o lista de persoane dupa nume, utilizand un comparator
//Comparatorul nu va fi definit printr-o clasa care sa implementeze interfata Comparator

        personList1.sort((p1, p2) -> Integer.valueOf(p1.getName().compareTo(p2.getName())));
        System.out.println(personList1);

//2. Sterge persoanele care nu pot vota
//Avand o lista de persoane, sterge din lista persoanele care au varsta
// mai mica decat 18 ani, folosind expresii lambda.

        personList1.removeIf((person -> person.getAge() < 14));
        System.out.println("Persoanele care au drept de vot " + personList1);
        return null;
    }
    //3.  Suma numerelor divizibile cu x sau cu y
//Scrie o metoda care sa calculeze suma numerelor divizibile
// cu x sau y (unde x si y sunt primiti ca parametri),
// dintr-o lista de Integer-uri.

    int x = 0;
    int y = 0;
    List<Integer> numbersList = List.of(20, 40, -60, 5);

    public static Integer printDivisibleNumbers(List<Integer> numbersList) {
        int x = 0;
        int y = 0;

        Optional<Integer> numbersL = numbersList.stream()
                .filter(number -> number % x == 0)
                .filter(number -> number % y == 0)
                .reduce((sum, numberss) -> sum + numberss);
        return numbersL.orElse(0);
    }
    public static int divisibleNumbersSum(List<Integer> numbers, int x, int y) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if ((numbers.get(i) % x == 0) && (numbers.get(i) % y == 0)) {
                sum += numbers.get(i);
            }
        }
        return sum;
    }

    //    todo 9
//    3. Sorteaza numerele dintr-un array
//    Scrie o metoda care sa sorteze numerele dintr-o lista de Integer-uri, dar inainte de asta sa le transforme in valori pozitive
//    Ex: Input: [-1,2,-3,4,-5]
//    Output:[1,2,3,4,5]
//            (HINT: map pentru a transforma fiecare numar din negativ in pozitiv, apoi sorted() ca si operatie finala. Foloseste Math.abs() pentru a transforma un numar din negativ in pozitiv)
//
//    Rezolva problema si fara expresii lambda
//
//    Rezolva problema si fara expresii lambda. (HINT: foloseste metoda sort din arraylist)

    public static List<Integer> returnPositiveNumbers(List<Integer> numbersList2) {
        List<Integer> sortedNumbers = numbersList2.stream()
                .map(number -> Math.abs(number))
                .sorted().toList();
        //  .collect(Collectors.toList());
        return sortedNumbers;
    }

    public static List<Integer> returnPositiveNumbersUsingNormalMethod(List<Integer> numbersList2) {
        List<Integer> convertNumbers = new ArrayList<>();
        for (int i = 0; i < numbersList2.size(); i++) {
            if (numbersList2.get(i) < 0) {
            convertNumbers.add(Math.abs(numbersList2.get(i)));
            convertNumbers.sort(Comparator.naturalOrder());
            }else {
                convertNumbers.add(numbersList2.get(i));
                convertNumbers.sort(Comparator.naturalOrder());


            }
        }
        return convertNumbers;
    }
    //todo 9
    //Afla profitul maxim pe care il poti
    // face cumparand si vanzand actiuni.
    //Ca si input ai un array cu preturile unei actiuni in fiecare zi. Va trebui sa
    // determini in ce zi trebuie sa cumperi si in ce zi trebuie sa vinzi ca sa obtii
    // profitul maxim
    //Exemplu:
    //Input: [100, 180, 260, 310, 40, 535, 695]
    //Output: Cumpara in ziua 5 (la pretul de 40) si vinde in ziua 7 (la pretul de 695), adica
    // profit maxim 695-40=655
    //Input2: [2, 3, 10, 6, 4, 8, 1]
    //Output: Cumpara in ziau 0 (la pretul de 2) si vinde in ziua 2 (la pretul de 10),
    // adica profit maxim 10-2=8
}