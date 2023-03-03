package seminar_1.hw1;

import java.time.LocalDate;

/**
 * Реализовать, с учетом ооп подхода, приложение Для проведения исследований с 
 * генеалогическим древом. Идея: описать некоторое количество компонент, например: 
 * модель человека компонента хранения связей и отношений между людьми: родитель, 
 * ребёнок - классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д. 
 * компонент для проведения исследований дополнительные компоненты, например отвечающие 
 * за вывод данных в консоль, загрузку и сохранения в файл, получение\построение отдельных 
 * моделей человека Под “проведением исследования” можно понимать получение всех детей 
 * выбранного человека. 
 */

public class Main {
    public static void main(String[] args) {
        FamilyMember Semeon = new FamilyMember(
                "Semeon",
                "Slepakov",
                FamilyMember.Sex.man,
                LocalDate.of(1950, 7, 21)
        ); FamilyMember Viktory = new FamilyMember(
                "Viktory",
                "Skladchikova",
                FamilyMember.Sex.woman,
                LocalDate.of(1954, 4, 22)
        ); FamilyMember Pavel = new FamilyMember(
                "Pavel",
                "Volya",
                FamilyMember.Sex.man,
                LocalDate.of(1984, 1, 20)
        ); FamilyMember Nadejda = new FamilyMember(
                "Nadejda",
                "Babkina",
                FamilyMember.Sex.woman,
                LocalDate.of(1989, 6, 13)
        ); FamilyMember Alexandr = new FamilyMember(
                "Alexandr",
                "Marshal",
                FamilyMember.Sex.man,
                LocalDate.of(2000, 7, 22)
        );

        FamilyTree familyTree = new FamilyTree()
                .appendChild(Semeon, Pavel).appendChild(Semeon, Nadejda).appendChild(Semeon, Alexandr)
                .appendChild(Viktory, Pavel).appendChild(Viktory, Nadejda).appendChild(Viktory, Alexandr)
                .appendMarried(Viktory, Semeon);

        System.out.println(familyTree);
        System.out.println(new Research(familyTree).spend(Semeon, Kinship.child));
        System.out.println(new Research(familyTree).complexSpend(Semeon));
        System.out.println(new Research(familyTree).complexSpend(Alexandr));
    }
}