package project; //import project  package name
/* The program generates simple random questions from inputed words
 * The program follows these rules and instructions 
 * <sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]
<simple_sentence> ::= <noun_phrase> <verb_phrase>
<noun_phrase> ::= <proper_noun> |
<determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]
<verb_phrase> ::= <intransitive_verb> |
<transitive_verb> <noun_phrase> |
is <adjective> |
hates that <simple_sentence>
<conjunction> ::= and | yet| for|  or | but | because | nor | even though|
<proper_noun> ::= Davis | Simon | Mr Stewart | Kim Smith
<common_noun> ::= man | woman | dog | policeman | boy  | bartender  |  
<determiner> ::= a | an | that | the | every | some| such
<adjective> ::= beautiful | smooth | pretty | big| charming | perfect| huge|
<intransitive_verb> ::= runs | die| smile | sit| jumps | talks | sleeps | sneeze
<transitive_verb> ::= loves | buy| clean| praise| hates | sees | knows | looks for | finds
 */
// creaating classes for each class of words
public class SimpleRandomSentences {
	static final String[] conjunction = { "and", "yet", "for", "or", "but", "because", "nor", "even though"};
	 static final String[] proper_noun = { "Davis", "Simon", "Mr Stewart","Kim Smith"};
	 static final String[] common_noun = { "man", "woman", "dog", "policeman", "boy", "bartender"};
	 static final String[] determiner = { "a","an", "that"  ,"the", "every", "some", "such"};
	 static final String[] adjective = { "beautiful", "smooth", "pretty","big", "charming", "perfect" ,"huge"};
	 static final String[] intransitive_verb = { "runs","die","smile", "sit" ,"jumps", "talks", "sleeps", "sneeze"};
	 static final String[] transitive_verb = { "loves","buy","clean", "praise", "hates", "sees", "knows", "looks for", "finds"};
	 public static void main(String[] args) {
	 while (true) {
	 randomSentence();
	 System.out.println(".\n\n");
	 try {
	 Thread.sleep(3000);
	 }
	 catch (InterruptedException e) {
	 }
	 }
	 }
	 static void randomSentence() {
	 randomNounPhrase();
	 randomVerbPhrase();
	 if (Math.random() > 0.75) {
	 System.out.print(" " + randomItem(conjunction));
	 randomSentence();
	 }
	 }
	 static void randomNounPhrase() {
	 if (Math.random() > 0.75)
	 System.out.print(" " + randomItem(proper_noun));
	 else
	 {
	 System.out.print(" " + randomItem(determiner));
	 if (Math.random() > 0.5)
	 System.out.print(" " + randomItem(adjective)+"");
	 System.out.print(" " + randomItem(common_noun));
	 if (Math.random() > 0.5){
	 System.out.print(" who" );
	 randomVerbPhrase();
	 }
	 }
	 }
	 static void randomVerbPhrase() {
	 if (Math.random() > 0.2)
	 System.out.print(" " + randomItem(intransitive_verb));
	 else if (Math.random() > 0.75) {
	 System.out.print(" " + randomItem(transitive_verb));
	 randomNounPhrase();
	 }
	 else if (Math.random() > 0.25)
	 System.out.print(" is " + randomItem(adjective));
	 else {
	 System.out.print(" hates that");
	 randomNounPhrase();
	 randomVerbPhrase();
	 }
	 }
	 static String randomItem(String[] listOfStrings){
	 return listOfStrings[(int)(Math.random()*listOfStrings.length)];
	 }


}
