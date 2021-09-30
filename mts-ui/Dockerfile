### STAGE 1: Build ###
FROM node:12.7-alpine AS build
WORKDIR /usr/src/app
COPY package.json ./
RUN npm cache clean --force
RUN npm cache verify
RUN npm install
RUN npm install --save-dev @angular-devkit/build-angular
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/src/mts.api/dist/mts-ui /usr/share/nginx/html
EXPOSE 80
