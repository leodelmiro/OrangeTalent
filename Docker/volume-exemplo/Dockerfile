FROM node:latest
MAINTAINER Leonardo Delmiro
COPY . /var/www
WORKDIR /var/www
RUN npm install
ENTRYPOINT ["npm", "start"]
EXPOSE 3000