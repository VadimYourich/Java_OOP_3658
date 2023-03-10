package seminar_1.hw1;

import java.time.LocalDate;
import java.util.*;

public class FamilyTreeParser extends JsonParser {


    public static String dump(FamilyTree familyTree) {
        List<Communication> communications = familyTree.communications();
        Set<Human> humans = familyTree.getHumans();
        StringBuilder json = new StringBuilder();
        json.append("{\"humans\":[");
        List<Human> h = humans.stream().sorted().toList();
        Human tempH;
        Communication tempC;
        for (int i = 0; i < h.size(); i++) {
            if (i > 0)
                json.append(",");
            tempH = h.get(i);
            json.append(String.format(
                    "{\"id\":\"%d\", \"first_name\":\"%s\", \"last_name\":\"%s\", \"sex\":\"%s\", \"birthday\":\"%s\"}",
                    tempH.id(), tempH.firstName(), tempH.lastName(), tempH.sex(), tempH.birthday()));
        }
        json.append("],\"communications\":[");
        communications = communications.stream().sorted().toList();
        for (int i = 0; i < communications.size(); i++) {
            if (i > 0)
                json.append(",");
            tempC = communications.get(i);
            json.append(String.format("{\"first_id\":\"%d\", \"kin\":\"%s\", \"second_id\":\"%d\"}",
                    tempC.firstId(), tempC.kin(), tempC.secondId()));
        }
        json.append("]}");
        return json.toString();

    }

    public static FamilyTree load(String jsonString) {
        List<Map<String, String>> humansFields = parse(jsonString, "humans");
        List<Map<String, String>> communicationsFields = parse(jsonString, "communications");
        List<Communication> communications = new ArrayList<>();
        Set<Human> humans = new HashSet<>();

        System.out.println(communicationsFields);
        for (Map<String, String> field : humansFields) {
            String[] date = field.get("birthday").split("-");
            humans.add(new FamilyMember(
                    Integer.parseInt(field.get("id")),
                    field.get("first_name"),
                    field.get("last_name"),
                    Human.Sex.valueOf(field.get("sex")),
                    LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]))
            ));
        }
        for (Map<String, String> field : communicationsFields) {
            communications.add(new MyCommunication(
                    Integer.parseInt(field.get("first_id")),
                    Integer.parseInt(field.get("second_id")),
                    Kinship.valueOf(field.get("kin"))
            ));
        }

        return new MyFamilyTree(communications, humans);

    }
}
