# Conversor de Monedas (Java + API ExchangeRate)

Este proyecto es una aplicación de consola desarrollada en **Java**, que permite convertir valores entre distintas monedas usando la API pública [ExchangeRate API](https://www.exchangerate-api.com/).

## Descripción

El programa ofrece un menú interactivo donde el usuario puede elegir la conversión entre las siguientes monedas:

- USD (Dólar estadounidense)
- ARS (Peso argentino)
- BRL (Real brasileño)
- COP (Peso colombiano)

Luego, solicita el monto a convertir, consulta la tasa actual a través de una llamada HTTP a la API y muestra el valor convertido.


## Ejemplo de uso
![Ejemplo de uso del conversor](images/Prueba1.png)

## 🔧 Tecnologías utilizadas

- Java (JDK 17 o superior recomendado)
- API: [ExchangeRate API](https://www.exchangerate-api.com/)
- Librerías externas:
  - `Gson` (para manejo de JSON)
