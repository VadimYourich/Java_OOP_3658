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
                0,
                "Semeon",
                "Slepakov",
                Human.Sex.MAN,
                LocalDate.of(1950, 7, 21)
        ); Human Viktory = new FamilyMember(
                1,
                "Viktory",
                "Skladchikova",
                Human.Sex.WOMAN,
                LocalDate.of(1954, 4, 22)
        ); Human Pavel = new FamilyMember(
                2,
                "Pavel",
                "Volya",
                Human.Sex.MAN,
                LocalDate.of(1984, 1, 20)
        ); Human Nadejda = new FamilyMember(
                3,
                "Nadejda",
                "Babkina",
                Human.Sex.WOMAN,
                LocalDate.of(1989, 6, 13)
        ); Human Alexandr = new FamilyMember(
                4,
                "Alexandr",
                "Marshal",
                Human.Sex.MAN,
                LocalDate.of(2000, 7, 22)
        );

        FamilyTree familyTree = new MyFamilyTree()
                .appendChild(Semeon, Pavel).appendChild(Semeon, Nadejda).appendChild(Semeon, Alexandr)
                .appendChild(Viktory, Pavel).appendChild(Viktory, Nadejda).appendChild(Viktory, Alexandr)
                .appendMarried(Viktory, Semeon);

        FileTransfer fileTransfer = new FileTransfer("familyTree.json");
        fileTransfer.write(FamilyTreeParser.dump(familyTree));

        familyTree = FamilyTreeParser.load(fileTransfer.read());

        System.out.println(new MyResearch(familyTree).spend(Semeon, Kinship.CHILD));
        System.out.println(new MyResearch(familyTree).complexSpend(Semeon));
        System.out.println(new MyResearch(familyTree).complexSpend(Alexandr));

        System.out.println(
                familyTree.find(HumanFilter.create()
                        .setLastName("Slepakov")
                        .setStartDate(LocalDate.of(1950,7,21))
                        .setSex(Human.Sex.MAN)
                )
        );
    }
}