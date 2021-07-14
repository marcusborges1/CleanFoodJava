# CleanFood
A simple version of a food delivery app using clean (ports and adapters/hexagonal) architecture. The main purpose here is to learn and practice.

This project is a work in progress and will change over time. My plan here is to start as simple as possible, without thinking on web frameworks, databases and other details.
If all goes well with this implementation, I will be able to think about these things at a later time.

Below is some information about the thoughts that guided the basis of this project.

# Useful concepts

## Clean Architecture

![alt text](https://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg "Clean Architecture organization")

Clean architecture is an architecture described by Robert C. Martin in a book with that name. It produces systems that are independent of framework, testable, independent of UI, independent of database and independent of any external agency. You can find more about it in [this post](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) on his own blog.

I will list bellow some of the key concepts and later how I think they can be applied to CleanFood.

### The dependency rule

wip

### Entities

An _entity_ is an object within our computer system that embodies a small set of critical business rules operating on critical business data. 

_Critical business rules_ are critical to the business itself, and would exist even if there were no system to automate them. They would make or save money if they were executed manually.

_Critical business data_ are data that would exist even if the system were not automated.

### Use Cases

Some business rules makes or saves money for the business by defining and constraining the way the _automated system_ operates. A _use case_ is a description of the way that an automated system is used.

It describes _application-specific business rules_ as opposed to the critical business rules within the entities.

### Interface Adapters

wip

### Framework and Drivers

wip

# CleanFood in practice

Before diving into implementation, some thought about the existing domain will be quite helpful to develop an application. 
In this topic we'll explore the food delivery domain as it is, without any automated application in the process. Later we'll
focus on entities and use case that we found after looking to our domain.

### Food delivery domain

First, let's think about how a food delivery occurs without a software managing it. In order to help us I'm going to list 
a script of what it was like to order a pizza in Parapipa Pizza before there were several apps that help us to do that. 

1. A customer sees a pizza catalog from Parapipa Pizza possibly with a promotion.
2. The customer calls the Parapipa Pizza store and orders a pepperoni pizza to a attendant.
3. The attendant takes the order, and the customer's address. He/She passes the order to the restaurant kitchen.
4. The pizzeria kitchen then prepares the pizza.
5. When the pizza is ready, the Parapipa Pizza passes the pizza to a delivery driver.
6. The delivery driver delivers the pizza to the customer's address.
7. The customer pays for the pizza and receives it.

Keep in mind that this is the happy path. The Parapipa Pizza could, for example, have its pepperoni sold out or
the attendant could have misunderstood the address and subsequently the delivery person arrived at the wrong house.

It's important to be aware of these unhappy paths, but to start simple we'll focus on happy path first.

### CleanFood entities

From here, we'll start to think in a modeling from real world to our software.
Bellow I'll list possible entities that we can find in the pizza delivery example listed before.

- **Customer:** A person that orders a food delivery from a merchant catalog to himself/herself and pays for it. 
- **(Food) Store:** The store that has an available food catalog and accepts food delivery orders from customers, delivering food through a driver.
- **(Food) Catalog:** From where customer can check available food and prices for a specific store.
- **Driver:** A person responsible for delivering an ordered food from merchant to customer.
- **Order:** A customer delivery request that informs customer address and chosen foods from merchant catalog.

There may be other entities that will become clearer as we evolve the project. Beforehand, it is expected, for example, 
that there is a Merchant entity that owns one or more stores or a Product entity which represent options from a Catalog, 
but as said before, let's start simple.

Looking at these entities and their domain we expect certain critical business data and critical business rules 
from them. I'll list examples bellow for some cases:

- **Critical Business Data**
  - **Customer:** address, payment info
  - **Store:** catalog
  - **Catalog:** products (food) listing, prices
  - **Order:** products chosen (by a customer), address to deliver
  
- **Critical Business Rules**
  - Customer: place an order for a store, pay an order
  - Store: confirm customer's order, pass the prepared order to a driver
  - Driver: delivers order to customer

### CleanFood first three use cases
- Customer orders food to a store
  - Input: customer's address, products list from catalog, store identification, payment info
  - Output: Same info for readback + notify store about the order
  - Primary Course: 
    1. Validate products from store catalog
    2. Validate payment info
    3. If products are available in store and payment info are valid: 
        - Charge the customer 
        - Create order
        - Notify store about the order
    4. Else 
        - Returns failure feedback message


- Store confirms customer's order 
  - Input: order identification, order confirmation (true/false) 
  - Output: Same info for readback
  - Primary Course: 
    1. Accept order confirmation
    2. If store accepts order
        - Update order status to accepted
        - notify the customer about order
    3. Else
        - Update order status to canceled
        - Notify customer
        - Uncharge the customer
  

- Store notifies driver about ready order
  - Input: 
  - Output:
  - Primary Course:
  
