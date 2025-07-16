# Access Control Simulator

This is a simple Java console application that simulates a basic role-based access control (RBAC) system. I built it to strengthen my understanding of identity and access management (IAM) concepts while practicing Java and object-oriented programming.

## What it does

- Create users and roles
- Assign roles to users
- Assign permissions to roles
- Check whether a user has a specific permission based on their assigned roles

It runs in the terminal and uses `Set`, `Map`, and basic input validation to simulate real-world access control behavior.

## Why I built it

I'm currently learning Java and preparing for a course this fall. Since I'm also pursuing a career in cybersecurity—specifically in IAM—I wanted to create something hands-on that blends both areas. This project helped me get more comfortable with Java classes, data structures, and thinking through access logic like you'd see in IAM systems.

## How it works

Each user can have multiple roles. Each role can have multiple permissions. When you check a user for a permission, the app checks all of the user's roles to see if any of them grant that permission.

## Example flow

1. Create a user: `Jalen`
2. Create a role: `Admin`
3. Assign the role `Admin` to `Jalen`
4. Assign permission `delete` to the role `Admin`
5. Check if `Jalen` has permission `delete` → returns true

## Future ideas

- Save users and roles to a file for persistence
- Add timestamps or basic logging
- Build a simple GUI using JavaFX later on

---
Built by [@doitformyset](https://github.com/doitformyset)
