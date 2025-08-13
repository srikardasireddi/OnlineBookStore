import React from "react";

const CartPopup = ({ book, onClose }) => (
  <div style={{
    position: "fixed", top: 0, left: 0, width: "100%", height: "100%",
    background: "rgba(0,0,0,0.5)", display: "flex", justifyContent: "center", alignItems: "center"
  }}>
    <div style={{ background: "#fff", padding: "30px", borderRadius: "10px", textAlign: "center" }}>
      <h3>Book Added to Cart</h3>
      <p>{book.title} by {book.author}</p>
      <p>Price: ${book.price}</p>
      <button onClick={onClose} style={{ background: "#4CAF50", color: "#fff", padding: "8px 12px", border: "none", borderRadius: "5px" }}>Close</button>
    </div>
  </div>
);

export default CartPopup;
