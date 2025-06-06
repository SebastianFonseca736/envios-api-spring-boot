#!/bin/bash

echo "🔄 Actualizando todos los microservicios..."

for dir in */; do
  if [ -d "$dir/.git" ]; then
    echo "📁 Entrando a $dir"
    cd "$dir"
    git pull
    cd ..
    echo ""
  else
    echo "⚠️  $dir no es un repositorio Git, lo salto."
  fi
done

echo "✅ Todos los microservicios actualizados."
