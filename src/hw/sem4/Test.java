package hw.sem4;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Test {
//    Создать справочник сотрудников
//    Необходимо:
//    Создать класс справочник сотрудников, который содержит внутри
//    коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
//    Табельный номер
//    Номер телефона
//    Имя
//    Стаж
//    Добавить метод, который ищет сотрудника по стажу (может быть список)
//    Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
//    Добавить метод, который ищет сотрудника по табельному номеру
//    Добавить метод добавление нового сотрудника в справочник

    public static void main(String[] args) {
        EmployeesMethods methods = new EmployeesMethods();
        methods.addNew(new Employees(2, 924, "Lucy", 3));
        methods.addNew(new Employees(9, 999, "Jacob", 2));
        methods.findByExper(3);
        methods.findByPersNumber(9);
        methods.getNumberByName("Jacob");
    }
}
