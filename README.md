
# 📚 Library Book Catalog API

A Spring Boot-based RESTful API to manage a digital library catalog.  
It supports basic CRUD operations such as adding, viewing, deleting, and updating the availability status of books.

---

## 📄 Project Description

This is a simple backend system for managing books in a library. Each book has the following details:

- `id` (Integer, auto-generated)
- `title` (String)
- `author` (String)
- `isbn` (String)
- `available` (Boolean)

Users can:

- Add a new book
- Retrieve all books
- Retrieve a book by its ID
- Delete a book
- Update a book's availability status

---


## 🛠️ Technologies Used

| Tech              | Purpose                            |
|-------------------|-------------------------------------|
| Java 17           | Core backend language               |
| Spring Boot 3.4.7 | RESTful API framework               |
| Maven             | Dependency and project management   |
| MySQL (Optional)  | Relational database (bonus feature) |
| Postman           | API testing and collection export   |
| Lombok            | Boilerplate code reduction          |

---

## 🚀 How to Run the Project

### 🟢 Prerequisites

- Java 17+
- Maven
- (Optional) MySQL 8+

---

### ▶️ Run with In-Memory Storage (No DB required)

1. Run the application:

   ```bash
   mvn spring-boot:run
   ```

2. Access the API at:  
   [http://localhost:8080](http://localhost:8080)

---

### 🟡 Run with MySQL Database (Optional)

1. Create a MySQL database:

   ```sql
   CREATE DATABASE BizDigitalLibraryApplication;
   ```

2. Configure database settings in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/BizDigitalLibraryApplication
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. Run the project:

   ```bash
   mvn spring-boot:run
   ```

---

## 🔁 API Endpoints

| Method | Endpoint                       | Description              |
|--------|--------------------------------|--------------------------|
| POST   | `/api/books`                   | Add a new book           |
| GET    | `/api/books`                   | Get all books            |
| GET    | `/api/books/{id}`              | Get a book by ID         |
| DELETE | `/api/books/{id}`              | Delete a book by ID      |
| PUT    | `/api/books/{id}/availability` | Update book availability |

---

## 📬 Sample Requests & Responses

### ➕ Add Book

**POST** `/api/books`  
**Request Body:**

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "available": true
}
```

**Response:**

```json
{
  "id": 6,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "available": true
}
```

---

### 📚 Get All Books

**GET** `/api/books`  
**Response:**

```json
[
  {
    "id": 1,
    "title": "The Hobbit",
    "author": "J.R.R. Tolkien",
    "isbn": "978-0547928227",
    "available": true
  },
  {
    "id": 2,
    "title": "1984",
    "author": "George Orwell",
    "isbn": "978-0451524935",
    "available": true
  }
]
```

---

### 🔎 Get Book by ID

**GET** `/api/books/1`  
**Success Response:**

```json
{
  "id": 1,
  "title": "The Hobbit",
  "author": "J.R.R. Tolkien",
  "isbn": "978-0547928227",
  "available": true
}
```

**Error Response:**

```
Book not found with ID: 99
```

---

### ❌ Delete Book

**DELETE** `/api/books/1`  
**Success Response:**

```
Book with ID 1 has been deleted.
```

**Error Response:**

```
Book not found with ID: 99
```

---

### 🔄 Update Availability

**PUT** `/api/books/2/availability?available=false`  
**Response:**

```
The book with ID 2 is currently unavailable in the library.
```

---

## 📮 Postman Collection

🔗 [Click here to view Postman Collection]([https://.postman.co/workspace/My-Workspace~fd965bf5-910a-4775-81aa-62760ca20ac5/collection/39805420-c0dd1a43-a85d-4bef-9011-09bc5d7d0a92?action=share&creator=39805420](https://www.postman.com/altimetry-geoscientist-65612259/libraryapiapplication/collection/kve85hb/libraryapiapplication?action=share&creator=39805420))  
*Replace with your actual exported Postman collection link.*


---

### 2️⃣ Clone the Repository

```bash
git clone https://github.com/Vedantimane/BizDigitalLibraryApplication.git
cd BizDigitalLibraryApplication
```
