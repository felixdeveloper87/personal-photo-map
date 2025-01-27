import { StrictMode } from 'react';
import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { createRoot } from 'react-dom/client';
import App from './App';
import './styles/index.css';
import { ChakraProvider } from '@chakra-ui/react';

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
      <ChakraProvider >
        <App /> {/* Envolva sua aplicação dentro do ChakraProvider */}
      </ChakraProvider>
    </BrowserRouter>
  </StrictMode>
);
