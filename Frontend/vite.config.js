import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    port: process.env.PORT || 8080, // Porta para o frontend no Docker
    host: true, // Permite expor para redes externas
    watch: {
      usePolling: true, // Necessário para Docker
    },
  },
})