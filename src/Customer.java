public record Customer(String id, String firstName, String lastName, String email,
                       double balance)  {

    public String id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String email() {
        return email;
    }

    public double balance() {
        return balance;
    }

    @Override
    public boolean equals (Object other) {
        if (this == other) return true;
        if (!(other instanceof Customer)) return false;
        Customer obj = (Customer) other;
        return this.id.equals(obj.id);
    }

    @Override
    public String toString() {
        return "Customer: \n" +
                "ID: " + id + "\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Balance: " + balance;
    }
}
