# E-commerce Shopping Cart System

This is a Java-based E-commerce Shopping Cart System designed to manage a customer's shopping cart, including adding products, checking out, and handling shipping and expiration logic for different product types (expiring and non-expiring items). The system ensures proper validation for stock availability, product expiration, and customer balance before completing a purchase.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Class Structure](#class-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

## Project Overview
The E-commerce Shopping Cart System allows customers to:
- Add products (expiring or non-expiring) to a cart.
- Check out with validation for product availability, expiration, and sufficient balance.
- Calculate shipping fees and total weight for shippable items.
- Generate a detailed receipt during checkout.

The project uses object-oriented principles, including inheritance, abstraction, polymorphism, and interfaces to support extensibility for different product types.

## Features
- **Cart Management**:
  - Add products to the cart with stock validation.
  - Clear the cart after a successful checkout.
  - Check if the cart is empty.
- **Checkout Process**:
  - Validates product expiration (for expiring items).
  - Calculates subtotal, shipping fees ($15 per shippable item), and total cost.
  - Verifies sufficient customer balance.
  - Displays shipment details (item weights and total package weight).
  - Generates a checkout receipt.
- **Product Types**:
  - **Expiring Items**: Products with an expiration date (e.g., food) that cannot be purchased if expired.
  - **Non-Expiring Items**: Products without an expiration date (e.g., electronics).
  - Both types can be shippable variants with weight > 0).
- **Shipping Logic**:
  - Only shippable items (with positive weight) are included in shipment calculations.
  - Total weight is calculated for shippable items.

## Class Structure
The project is organized in the `ecommerce.model` package.

### Classes and Interfaces
- **`Product.java`**: Abstract base class for all products. Defines common attributes (`name`, `price`, `quantity`) and an abstract method (`IsShippable`).
- **`ExpiringItem.java`**: Extends `Product` and implements `ShippableItem`. Represents products with an expiration date and optional weight for shipping.
- **`NonExpiringItem.java`**: Extends `Product` and implements `ShippableItem`. Represents products without an expiration date and optional weight for shipping.
- **`ShippableItem.java`**: Interface defining the `getWeight` method for shippable products.
- **`Cart.java`**: Manages the shopping cart, allowing addition of products, retrieval of items, and clearing the cart.
- **`Customer.java`**: Represents a customer with a cart and balance. Handles the checkout process, including validation, shipment details, and receipt generation.

## Getting Started
### Prerequisites
- Java Development Kit (JDK) 8 or higher.
- An IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with Java compilation support.
- Basic knowledge of Java, object-oriented programming, and Java's `LocalDate` class.

### Installation
1. Clone or download the project repository.
2. Open the project in your preferred IDE.
3. Ensure the project structure includes the `ecommerce.model` package with all provided Java files.
4. Compile and run the project.

## Usage
1. **Create Products**:
   ```java
   import ecommerce.model.*;
   import java.time.LocalDate;

   ExpiringItem milk = new ExpiringItem("Milk", 3.99, 10, LocalDate.of(2025, 12, 31), 1.0);
   NonExpiringItem laptop = new NonExpiringItem("Laptop", 999.99, 5, 2.5);
