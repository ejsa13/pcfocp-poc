FROM alpine
COPY *-configmap . 
COPY *-template.yaml .
COPY create-configmap .
COPY download-properties .
COPY refresh-configmap .
RUN apk add curl openssl yq && \
    chmod u+x create-configmap && \
    chmod u+x refresh-configmap && \
    chmod u+x download-properties

     