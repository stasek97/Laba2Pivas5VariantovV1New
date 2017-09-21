package StudentInformationProgect.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mayakov Stanislav on 21.09.2017.
 */
public class BasicList {
    private  Students students;
    public BasicList(){
    students = new Students();
    Field field = new Field();
    List<Field> fields = new ArrayList<>();
    fields.add(field);
    field.setValue("Please reload the list");
    field.setName("Students list is empty");
    students.setFieldList(fields);
    }

    public Students getBasicList(){
        return students;
    }

}
