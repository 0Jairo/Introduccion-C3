# Introduction to git

# Basics Commands

- <strong>git init</strong> (se realiza una sola vez, esto con la finalidad de añadir el proyecto a git)
- <strong>git add .</strong> <i>ó</i> <strong>git add nombre-archivo</strong> (adicionar los archivos al staging area)
- <strong>git commit -m "mensaje_commit"</strong> (guardar los archivos que están en el stage area con un comentario)
- <strong>git push origin main</strong> (subir los cambios al repositorio github/gitlab)
- <strong>git status</strong> (verificar los archivos que están dentro y fuera del stage área)
- <strong>git log</strong> (visualizar los commits de nuestro proyecto)
- <strong>git log --oneline</strong> (visualizar commits y ramas del proyecto)
- <strong>git branch</strong> (visualizar todas las ramas del proyecto)
- <strong>git branch nombre-rama</strong> (crear nueva rama)
- <strong>git checkout nombre-rama</strong> (cambiar de rama)
- <strong>git merge nombre-rama</strong> (unir ramas / unir commits de dos ramas)
- <strong>git branch -d nombre-rama</strong> (eliminar una rama)
- <strong>git clone url-repositorio</strong> (clonar un repositorio remoto)
- <strong>git pull origin nombre-rama</strong> (traer cambios del repositorio, (indicando la rama de la cual traere los cambios))


# Config

- start-ssh-agent (Habilitar agente ssh en windows)
- git config --local user.name "Tu nombre aquí"
- git config --local user.email "Tu@email.aqui”


### Tools

- Fig -> autoComplete (mac or linux)
- oh-my-zsh (mac or linux)