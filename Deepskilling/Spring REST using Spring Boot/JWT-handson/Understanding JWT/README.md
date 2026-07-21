# Understanding JWT (JSON Web Token)

## Concept Overview
- **JWT (JSON Web Token)** is a compact and self-contained open standard (RFC 7519) used to securely transmit JSON-based information/claims between a client and a server.
- Unlike cookie-based sessions, JWT is designed for stateless RESTful services. The client stores the token (usually in LocalStorage or sessionStorage) and attaches it to the `Authorization` header on subsequent requests:
  `Authorization: Bearer <token>`

---

## JWT Structure
A JSON Web Token consists of three parts separated by periods (`.`):
1. **Header**: Contains the hashing algorithm (e.g., HS256, RS256) and the token type (JWT).
2. **Payload**: Contains claims (user data such as `sub` for subject/username, roles, `iat` for issue time, and `exp` for expiration).
3. **Signature**: Validates the authenticity of the token to prevent tampering. Calculated by combining the encoded Header, encoded Payload, a secret key, and the algorithm specified in the Header.

---

## Token Verification Exercise
To verify token creation:
1. Open the [JWT.io Debugger](https://jwt.io/).
2. Input the Header and Payload properties.
3. Add a secret key signature (e.g. `secretkey`) under the "Verify Signature" section.
4. Verify that the generated token in the Encoded section matches standard encoded tokens exactly.
