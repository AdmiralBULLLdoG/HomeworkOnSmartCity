

public class Student {
    private String name;
    private String lastName;
    private String patronymic;
    private int year;
    private int day;
    private int month;
    private String address;
    private String telephone;
    private String faculty;
    private int course;
    private String group;

    public Student(String name, String lastName, String patronymic, int year, int month, int day, String address, String telephone, String faculty, int course, String group) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.year = year;
        this.day = day;
        this.month = month;
        this.address = address;
        this.telephone = telephone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public Student(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", year=" + year +
                ", day=" + day +
                ", month=" + month +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", group='" + group + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    void printFacultyTrue(String faculty) {
        if (this.faculty.equals(faculty))
            System.out.println(toString());
    }

    void printYearTrue(int year) {
        if (this.year > year)
            System.out.println(toString());
    }
    void printGroupTrue(String group) {
        if (this.group.equals(group))
            System.out.println(toString());
    }
}
