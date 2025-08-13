import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar.jsx";
import Footer from "./components/Footer.jsx";
import Hero from "./components/Hero.jsx";
import BookList from "./components/BookList.jsx";
import Orders from "./components/Orders.jsx";

const App = () => {
  const [cartItems, setCartItems] = useState([]);

  return (
    <Router>
      <Navbar cartCount={cartItems.length} />
      <Hero />
      <Routes>
        <Route path="/" element={<BookList cartItems={cartItems} setCartItems={setCartItems} />} />
        <Route path="/orders" element={<Orders cartItems={cartItems} setCartItems={setCartItems} />} />
      </Routes>
      <Footer />
    </Router>
  );
};

export default App;
