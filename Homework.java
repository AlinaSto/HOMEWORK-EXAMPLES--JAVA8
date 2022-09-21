package HomeworkSesiunea17;

import LambdaPerson.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        //todo 3
        List<Integer> numbersList2 = List.of(-20, -40, -60, -5, 8);
        System.out.println("-----------------------------------");
        System.out.println(returnPositiveNumbers(numbersList2));
        System.out.println(returnPositiveNumbersUsingNormalMethod(numbersList2));
        //todo 4

        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23));
        list.add(new Person("Joe", 18));
        list.add(new Person("Ryan", 54));
        list.add(new Person("Iyan", 5));
        list.add(new Person("Ray", 63));
        System.out.println(isPersonEligibleForVoting(list));
        System.out.println(isPersonEligibleForVoting2(list));

        //todo 5
        String text = "maine estse prima zi de sicoala a Anei carbe sa trezit nerabdatoare";
        List<String> badWords = Arrays.asList("sa", "sicoala", "carbe");
        System.out.println(foundBadWords(text, badWords));
        System.out.println(foundBadWords2(text, badWords));

        //todo 6 Profitul maxim
        List<Integer> prices = new ArrayList<>();
        prices.add(2);
        prices.add(25);
        prices.add(152);
        prices.add(589);
        prices.add(21);
        prices.add(444);
        prices.add(84);
        System.out.println(getMaximProfit(prices));

        //todo 7

//        List<Integer> multiply = List.of(1, 2, 3, 4, 5);
//        System.out.println(multiplyRestOfTheNumbers(multiply));

        //todo 85
        List<Integer> verifyDuplicatesNumbers = List.of(3, 2, 3, 4, 5);
        System.out.println(checkDuplicateNumbers(verifyDuplicatesNumbers));
    }

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
            } else {
                convertNumbers.add(numbersList2.get(i));
                convertNumbers.sort(Comparator.naturalOrder());


            }
        }
        return convertNumbers;
    }

    //todo 4. Filtreaza persoanele care pot vota
    //O persoana este caracterizata de nume si varsta.
    //Scrie o metoda statica numita isPersonEligibleForVoting(),
    // care accepta ca parametru o lista de persoane si returneaza o lista cu
    // persoanele care pot vota.
    public static List<Person> isPersonEligibleForVoting(List<Person> list) {
        return list.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toList());
    }

    public static List<Person> isPersonEligibleForVoting2(List<Person> list) {
        List<Person> eligiblePersons = new ArrayList<>();
        for (Person person : list) {
            if (person.getAge() > 18) {
                eligiblePersons.add(person);
            }
        }
        return eligiblePersons;
    }

    // todo 5 Spell checker 2
    //Avand intr-un main un String, in care se stocheaza un text si o lista de cuvinte gresite, scrie o functie
    // care accepta acesti 2 parametrii si returneaza lista cu cuvintele gresite care se regasesc in text
    //Ex: Input: String text = “acesta etse nu text”
    //                List<String> badWords = [“etse”, “nu”, “acetsa”, “extt”]
    //Output: [“etse”, “nu”], pentru ca acestea sunt cuvintele din badWords care se regasesc in text
    //(HINT: stream pe lista badWords, apoi filtram doar cuvintele care sunt continute in text (folosind metoda contains()) )
    public static List<String> foundBadWords(String text, List<String> badWords) {
        List<String> foundWords = badWords.stream()
                .filter(word -> text.contains(word))
                .collect(Collectors.toList());
        return foundWords;
    }

    public static List<String> foundBadWords2(String text, List<String> badWords) {
        List<String> foundWords = new ArrayList<>();
        for (String word : badWords) {
            if (text.contains(word)) {
                foundWords.add(word);
            }
        }
        return foundWords;
    }


    //todo Profitul maxim

    //Afla profitul maxim pe care il poti face cumparand si vanzand actiuni.
    //Ca si input ai un array cu preturile unei actiuni in fiecare zi. Va trebui sa
    // determini in ce zi trebuie sa cumperi si in ce zi trebuie sa vinzi ca sa obtii profitul maxim
    //Exemplu:
    //Input: [100, 180, 260, 310, 40, 535, 695]
    //Output: Cumpara in ziua 5 (la pretul de 40) si vinde in ziua 7 (la pretul de 695),
    // adica profit maxim 695-40=655
    //Input2: [2, 3, 10, 6, 4, 8, 1]
    //Output: Cumpara in ziau 0 (la pretul de 2) si vinde in ziua 2 (la pretul de 10),
    // adica profit maxim 10-2=8
    //1. parcurgem lista sa gasim ziua cu pretul maxim
    //2. parcurgem lista (pana la ziua cu pretul maxim)sa gasim ziua cu pretul minim
    //3. calculam profitul

    public static int getMaximProfit(List<Integer> prices) {
        int maxPrice = Integer.MIN_VALUE;
        int dayWithMaxPrice = 0;
        int minPrice = Integer.MAX_VALUE;
//
//        for (int i = 0; i < prices.size(); i++) {
//            if (prices.get(i) > maxPrice) {
//                maxPrice = prices.get(i);
//                dayWithMaxPrice = i;
//            }
//        }
//        for (int i = 0; i < dayWithMaxPrice; i++) {
//            if (prices.get(i) < minPrice) {
//                minPrice = prices.get(i);
//            }
//        }
//        return maxPrice - minPrice;


        Optional<Integer> optionalProfit = prices.stream()
                .filter(price -> price > maxPrice)
                .filter(price -> price < minPrice)
                .reduce((max, min) -> max - min);
        return optionalProfit.orElse(0);
    }
//todo 7 produsul elementelor

    // Inlocuieste fiecare element dintr-un array cu produsul tuturor celorlalte elemente
//Exemplu:
//Input: { 1, 2, 3, 4, 5 }
//Output: { 120, 60, 40, 30, 24 }
    //   private static List<Integer> multiplyRestOfTheNumbers(List<Integer> multiply) {
    //  List<Integer> multiply = List.of(1,2,3,4,5);

    //        List<Integer> multiplyResult = new ArrayList<>();
//        int depositMultiply = multiply.get(0);
//        int depositDivide = 1;
//        for (int i = 1; i < multiply.size(); i++) {
//            depositMultiply *= multiply.get(i);
//            for (int j = 0; j < multiply.size(); j++) {
//                multiply.get(i) = depositMultiply / multiply.get(i);
//                multiplyResult.add(depositMultiply);
//        -------------------------------------------------------------------
//        }
//}
//        return multiplyResult;
//                }
//
//
//todo 8 - 3
    //Sa se verifice daca un array contine duplicate
    //Exemplu:
    //Input: [6,5,6,2,3,1]
    //Output: true, pentru ca 6 apare de doua ori
    //todo 1
//    public static boolean checkDuplicateNumbers(List<Integer> verifyDuplicatesNumbersy) {
//        for (int i = 0; i < verifyDuplicatesNumbersy.size(); i++) {
//            for (int j = i + 1; j < verifyDuplicatesNumbersy.size(); j++) {
//                if (verifyDuplicatesNumbersy.get(i).equals(verifyDuplicatesNumbersy.get(j))) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


    //todo 2

    public static Map<Integer, Long> checkDuplicateNumbers(List<Integer> verifyDuplicatesNumbersy) {
        // Map<Integer, List<Integer>> counter = new HashMap<>();
        Map<Integer, Long> counts = verifyDuplicatesNumbersy.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return counts;
    }

//todo 8 - 4
    //4. Sunt afisate n-1 numere dintr-un interval de la 1 la n. Sa se gaseasca numarul care lipseste.
    //Exemplu:
    //Input: n=7, a=[3,2,1,6,5,7]
    //Output: 4 - lipseste doar 4 din array.
    //
    //(hint: sorteaza array-ul si verifica daca gasesti o diferenta de 2 intre 2 elemente consecutive. Un gasesti diferenta,
    // acolo va fi si numarul care lipseste. Gandeste-te apoi si la alta metoda de rezolvare)

}
