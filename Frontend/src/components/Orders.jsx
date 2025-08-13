import React, { useState, useEffect } from "react";

const Orders = ({ cartItems, setCartItems }) => {
  const [orders, setOrders] = useState([]);
  const [placedOrders, setPlacedOrders] = useState([]);

  // Sync cartItems to orders
  useEffect(() => {
    setOrders(cartItems);
  }, [cartItems]);

  const deleteOrder = (index) => {
    const updatedOrders = [...orders];
    updatedOrders.splice(index, 1);
    setOrders(updatedOrders);
    setCartItems(updatedOrders); // sync back to cart
  };

  const placeOrders = () => {
    setPlacedOrders([...orders]);
    setOrders([]);
    setCartItems([]);
    alert("Order placed successfully!");
  };

  return (
    <div className="container">
      <h2 style={{ color: "#4CAF50" }}>Your Orders</h2>
      {orders.length === 0 && <p>No orders in cart. Add books first!</p>}
      {orders.map((order, idx) => (
        <div key={idx} style={{ background: "#fff", margin: "10px 0", padding: "10px", borderRadius: "8px", display: "flex", justifyContent: "space-between" }}>
          <div>
            <h4>{order.title}</h4>
            <p>Author: {order.author}</p>
            <p> ${order.price}</p>
          </div>
          <button style={{ background: "#f44336", color: "#fff", border: "none", padding: "8px 12px", borderRadius: "5px" }} onClick={() => deleteOrder(idx)}>Delete</button>
        </div>
      ))}
      {orders.length > 0 && (
        <button onClick={placeOrders} style={{ background: "#4CAF50", color: "#fff", padding: "10px 15px", border: "none", borderRadius: "5px", marginTop: "10px" }}>
          Place Order
        </button>
      )}

      {placedOrders.length > 0 && (
        <div style={{ marginTop: "30px" }}>
          <h3 style={{ color: "#2196F3" }}>Placed Orders</h3>
          {placedOrders.map((order, idx) => (
            <div key={idx} style={{ background: "#e3f2fd", padding: "10px", borderRadius: "8px", margin: "5px 0" }}>
              <h4>{order.title}</h4>
              <p>Author: {order.author}</p>
              <p> ${order.price}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default Orders;
