import React, { useEffect, useState } from "react";
import axios from "axios";
import CartPopup from "./CartPopup.jsx";

const BookList = ({ cartItems, setCartItems }) => {
  const [books, setBooks] = useState([]);
  const [showPopup, setShowPopup] = useState(false);
  const [selectedBook, setSelectedBook] = useState(null);

  useEffect(() => {
    axios.get("http://localhost:8080/books")
      .then(res => setBooks(res.data))
      .catch(err => console.error(err));
  }, []);

  const addToCart = (book) => {
    setCartItems([...cartItems, book]);
    setSelectedBook(book);
    setShowPopup(true);
  };

  return (
    <div className="container">
      <h2 style={{ color: "#4CAF50" }}>Available Books</h2>
      <div style={{ display: "flex", flexWrap: "wrap", gap: "20px" }}>
        {books.map(book => (
          <div key={book.id} style={{ background: "#fff", padding: "15px", borderRadius: "8px", width: "250px", boxShadow: "0 4px 6px rgba(0,0,0,0.1)" }}>
            <h3 style={{ color: "#333" }}>{book.title}</h3>
            <p>Author: {book.author}</p>
            <p> ${book.price}</p>
            <button style={{ background: "#4CAF50", color: "#fff", border: "none", padding: "8px 12px", borderRadius: "5px" }} onClick={() => addToCart(book)}>Add to Cart</button>
          </div>
        ))}
      </div>
      {showPopup && <CartPopup book={selectedBook} onClose={() => setShowPopup(false)} />}
    </div>
  );
};

export default BookList;
