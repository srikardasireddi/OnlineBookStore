import React from "react";
import { Link } from "react-router-dom";

const Navbar = ({ cartCount }) => {
  return (
    <nav style={{ background: "#4CAF50", padding: "10px", color: "#fff" }}>
      <div className="container" style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
        <h2>Online Bookstore</h2>
        <div>
          <Link to="/" style={{ margin: "0 15px", color: "#fff" }}>Home</Link>
          <Link to="/orders" style={{ margin: "0 15px", color: "#fff" }}>Orders ({cartCount})</Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
