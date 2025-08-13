import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/orders': 'http://localhost:8080',
      '/books': 'http://localhost:8080'
    }
  }
});
