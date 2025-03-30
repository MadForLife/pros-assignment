# Take-Home Assignment

## Repository Structure

- **`sub1/`** – Contains the driver for Task 1.  
- **Spring Boot Project** – The implementation for Tasks 2 and 3 follows a standard Spring Boot project structure.

---

## Task 2 & 3: API Endpoints  

**POST** `http://localhost:8080/api/flights/routes`  

#### **Example Request With max flights:**  

```json
{
  "origin": "SOF",
  "destination": "MLE",
  "maxFlights": 2
}
```

#### **Example Request without max flights:**
```json
{
  "origin": "SOF",
  "destination": "MLE"
}
```
