export const getBooks = async () => {
  const res = await fetch("http://localhost:8082/books");
  if (!res.ok) throw new Error("Failed to fetch books");
  return res.json();
};
