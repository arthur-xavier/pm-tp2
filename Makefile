all: build

build:
	javac pm/**/*.java

clean:
	rm -rf pm/truco/**/*.class
	rm -rf pm/truco/*.class
	rm -rf doc/*.aux
	rm -rf doc/*.log

run:
	java pm/truco/Main

# Documentação
doc:
	pdflatex -output-directory=doc doc/doc.tex
	cp doc/doc.pdf Truco_ArthurXavier_JotaJunior.pdf
	
.PHONY: clean doc
