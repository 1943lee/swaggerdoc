# swagger static api generate
> This project works with swagger2.

1. Run the project to generate a ascii doc file.
2. Run the maven plugin `asciidoctor:process-asciidoc` to generate a well-designed html file.

- Note that the file path should be the same with the maven plugin setting in the pom.xml.

## config detail
### swagger2 api-docs location url
```
api-docs.url=http://localhost:80080/v2/api-docs
```
### output ascii doc file path
```
adocFile.path=docs/asciidoc/generated/
```
> indicates the ascii file path.Default name is index.adoc