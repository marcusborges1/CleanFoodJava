# CleanFood
A simple version of a food delivery app using clean (ports and adapters/hexagonal) architecture. The main purpose here is to learn and practice.

This project is a work in progress and will change over time. My plan here is to start as simple as possible, without thinking on web frameworks, databases and other details. 

If all goes well with this implementation, I will be able to think about these things at a later time.

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

Some business rules make or save money for the business by defining and constraining the way the _automated system_ operates. A _use case_ is a description of the way that an automated system is used.

It describes _application-specific business rules_ as opposed to the critical business rules within the entities.

### Interface Adapters

wip

### Framework and Drivers

wip

# CleanFood in practice

### Food Delivery Entities
- **Customer:** A person that orders a food delivery from a merchant catalog to himself/herself and pays for it. 
- **Merchant:** The store that has an available food catalog and accepts food delivery orders from customers, delivering food through a driver.
- **Driver:** A person responsible for delivering an ordered food from merchant to customer.
- **Order:** A customer delivery request that informs customer address and chosen foods from merchant catalog.

(wip)

Customer#make_an_order

Merchant#confirm_customer_order

### CleanFood use cases
- Customer orders food from a merchant
  - Input: wip
  - Output: wip
  - Primary Course: wip
  
