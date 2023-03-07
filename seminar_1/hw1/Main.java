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
 * 
 * Используйте предыдущие задачи из прошлого домашнего задания. Необходимо гарантированно 
 * продумать иерархию компонент и взаимодействия их между собой.
 * Обеспечить переход от использования явных классов в сторону использования абстрактных типов. 
 * Т.е. работаем не с конкретным экземпляром генеалогического древа, а с интерфейсом 
 * “генеалогическое древо”.
 */

public class Main {
    public static void main(String[] args) {
        Human Semeon = new FamilyMember(
                "Semeon",
                "Slepakov",
                FamilyMember.Sex.MAN,
                LocalDate.of(1950, 7, 21)
        ); Human Viktory = new FamilyMember(
                "Viktory",
                "Skladchikova",
                FamilyMember.Sex.WOMAN,
                LocalDate.of(1954, 4, 22)
        ); Human Pavel = new FamilyMember(
                "Pavel",
                "Volya",
                FamilyMember.Sex.MAN,
                LocalDate.of(1984, 1, 20)
        ); Human Nadejda = new FamilyMember(
                "Nadejda",
                "Babkina",
                FamilyMember.Sex.WOMAN,
                LocalDate.of(1989, 6, 13)
        ); Human Alexandr = new FamilyMember(
                "Alexandr",
                "Marshal",
                FamilyMember.Sex.MAN,
                LocalDate.of(2000, 7, 22)
        );

        FamilyTree familyTree = new MyFamilyTree()
                .appendChild(Semeon, Pavel).appendChild(Semeon, Nadejda).appendChild(Semeon, Alexandr)
                .appendChild(Viktory, Pavel).appendChild(Viktory, Nadejda).appendChild(Viktory, Alexandr)
                .appendMarried(Viktory, Semeon);

        System.out.println(familyTree);
        System.out.println(new MyResearch(familyTree).spend(Semeon, Kinship.CHILD));
        System.out.println(new MyResearch(familyTree).complexSpend(Semeon));
        System.out.println(new MyResearch(familyTree).complexSpend(Alexandr));
    }
}