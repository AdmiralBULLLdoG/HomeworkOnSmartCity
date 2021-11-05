import java.util.Comparator;

public class Customer implements Comparable<Customer> {
    private String id;
    private String name;
    private String lastName;
    private String patronymic;
    private String address;
    private int creditCardNumber;
    private String bankAccountNumber;

    public Customer(String id, String name, String lastName, String patronymic, String address, int creditCardNumber, String bankAccountNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public int compareTo(Customer customer) {
        return (this.creditCardNumber - customer.creditCardNumber);
    }

    public static Comparator<Customer> LastNameComparator = new Comparator<Customer>() {

        @Override
        public int compare(Customer e1, Customer e2) {
            return e1.getLastName().compareTo(e2.getLastName());
        }
    };

    public static Comparator<Customer> NameComparator = new Comparator<Customer>() {

        @Override
        public int compare(Customer e1, Customer e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };
}
