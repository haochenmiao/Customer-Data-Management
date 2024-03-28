# Customer Data Management System

## Introduction

This project is a Java-based Customer Data Management System designed to organize and manage customer data efficiently. Utilizing a custom linked list implementation, the system allows for quick access and manipulation of customer records stored in text files. It features functionality to add, find, and generate CSV files of customer data.

## Features

- Load customer data from a specified text file.
- Find a customer by last name and ID.
- Generate a CSV file containing all customer records.
- Store customer records in a tagged linked list structure for efficient data retrieval.
- Unit tests for validating the functionality of the data manager.

## Diagram Screenshots
![Class UML Diagram](https://github.com/haochenmiao/Customer-Data-Management/blob/main/DesignDocs/Proj03%20diagram%20-%20Class%20diagram.png)

![Object UML Diagram](https://github.com/haochenmiao/Customer-Data-Management/blob/main/DesignDocs/Proj03%20diagram%20-%20Object%20diagram.png)


## Requirements

- Java Development Kit (JDK) 11 or newer.
- JUnit 5 for running unit tests.

## Installation

1. Clone the repository to your local machine:
```sh
    git clone https://github.com/haochenmiao/Customer-Data-Management.git
```

2. Navigate to the cloned directory:
```sh
    cd customer-data-management
```

## Usage

### Running the Main Application

To run the main application, execute:
```sh
    java Main.java
```

This will load customer data from `Customers.txt`, attempt to find a specific customer, and generate a CSV file `customers.csv` with all customer data.

### Adding Customer Data

Customer data should be added to the `Customers.txt` file in the following format:
```sh
    id,lastName,firstName,email,balance
```

## Testing

To run the unit tests, use the following command:

```sh
    java -jar junit-platform-console-standalone.jar -cp . --scan-classpath
```

Ensure that you have `junit-platform-console-standalone.jar` in your project directory.

## Contributing

We welcome contributions to improve the project! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature.
3. Commit your changes.
4. Push to your branch.
5. Submit a pull request.

## License

This project is open-source and available under the [MIT License](LICENSE).
