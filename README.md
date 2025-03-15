# foodexpress
Food Delivery App

# eureka-server
This helps the microservice to discover other services dynamically, making the system more tolerant and scalable

It consists of two components:

1. Eureka Server (Service Registry)

    Maintains a registry of all registered services.

    Services register themselves and send heartbeats to remain active. 

2. Eureka Clients (Microservices)

    Register themselves with Eureka Server.
    
    Discover other services dynamically via Eureka. Uses Ribbon (for load balancing) and Feign (for REST communication).