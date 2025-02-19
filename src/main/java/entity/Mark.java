package entity;

import java.util.Objects;

public class Mark {
    private int id;
    private Student student;
    private Term term;

    private Discipline discipline;
    private int mark;

    public Mark() {
    }

      public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Term getTerm() {
        return term;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public int getMark() {
        return mark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark1 = (Mark) o;
        return id == mark1.id && mark == mark1.mark && Objects.equals(student, mark1.student) && Objects.equals(term, mark1.term) && Objects.equals(discipline, mark1.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, term, discipline, mark);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", student=" + student +
                ", term=" + term +
                ", discipline=" + discipline +
                ", mark=" + mark +
                '}';
    }
}
