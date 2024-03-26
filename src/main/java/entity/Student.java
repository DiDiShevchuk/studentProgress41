package entity;

import java.sql.Date;
import java.util.Objects;

public class Student {
    private int id;
    private String surname;

    private String name;
    private String groupe;
    private Date date;
    private int status = 1;

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && status == student.status && Objects.equals(surname, student.surname) && Objects.equals(name, student.name) && Objects.equals(groupe, student.groupe) && Objects.equals(date, student.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, groupe, date, status);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", groupe='" + groupe + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
