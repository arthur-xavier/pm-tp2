all: build

build:
	javac pm/truco/**/*.java
	javac pm/truco/*.java

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

# Testes
test_%:
	@echo "\n! Testando \"$@\""
	java pm/truco/Main < test/$@/in.txt > test/$@/$@.log
	diff test/$@/out.txt test/$@/$@.log

test:

.PHONY: clean doc
