package com.example.mobileproject.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Questions implements Serializable {
    private String question;
    private String goodanswer;
    private String answer2;
    private String answer3;
    private String answer4;
    private String justification;
    private int id;
    private static int idcounter=0;
    private static List<Questions> questionsList;

    public String getQuestion() {
        return question;
    }

    public String getGoodanswer() {
        return goodanswer;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getJustification() {
        return justification;
    }

    public int getId() {
        return id;
    }

    public Questions(String question, String goodanswer, String answer2, String answer3, String answer4, String justification) {
        this.question = question;
        this.goodanswer = goodanswer;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.justification = justification;
        idcounter++;
        this.id=idcounter;
    }
    public static List<Questions> IniList() {
        List<Questions> questionsList = new ArrayList<>();

        questionsList.add(new Questions(
                "Quelle est la première étape à suivre après avoir détecté un logiciel malveillant sur votre ordinateur professionnel?",
                "Déconnecter l'ordinateur du réseau",
                "Continuer à utiliser l'ordinateur pour identifier le malware",
                "Redémarrer l'ordinateur",
                "Installer immédiatement un nouveau logiciel antivirus",
                "Déconnecter l'ordinateur du réseau empêche la propagation du malware à d'autres systèmes et permet une analyse sécurisée."
        ));

        questionsList.add(new Questions(
                "Que signifie le terme 'hameçonnage' ?",
                "Une tentative de tromperie pour obtenir des informations sensibles",
                "Un outil de détection de logiciels malveillants",
                "Une méthode pour renforcer les mots de passe",
                "Un type de virus informatique",
                "L'hameçonnage est une technique utilisée par les cybercriminels pour tromper les gens afin qu'ils révèlent des informations confidentielles."
        ));

        questionsList.add(new Questions(
                "Qu'est-ce qu'un VPN ?",
                "Un réseau privé virtuel qui sécurise la connexion Internet",
                "Un logiciel antivirus",
                "Un type de logiciel malveillant",
                "Un outil de gestion de mots de passe",
                "Un VPN crée une connexion sécurisée et cryptée, offrant plus de confidentialité qu'une connexion Wi-Fi non sécurisée."
        ));

        questionsList.add(new Questions(
                "Quelle est la meilleure méthode pour gérer de nombreux mots de passe ?",
                "Utiliser un gestionnaire de mots de passe",
                "Noter les mots de passe sur un papier",
                "Utiliser le même mot de passe pour plusieurs comptes",
                "Créer des mots de passe simples et faciles à retenir",
                "Un gestionnaire de mots de passe stocke de manière sécurisée vos mots de passe et peut générer des mots de passe forts et uniques pour chaque compte."
        ));

        questionsList.add(new Questions(
                "Quelle est la caractéristique principale d'un 'cheval de Troie' ?",
                "Se présenter comme un logiciel légitime tout en dissimulant du code malveillant",
                "Crypter les fichiers pour demander une rançon",
                "Créer des copies de lui-même sur l'ordinateur",
                "Bloquer l'accès à Internet",
                "Un cheval de Troie se déguise en logiciel légitime pour tromper les utilisateurs et installer du malware."
        ));

        questionsList.add(new Questions(
                "Qu'est-ce qu'une attaque par déni de service (DoS) ?",
                "Inonder un système de trafic pour le rendre inopérant",
                "Voler des données utilisateur",
                "Envoyer des e-mails de phishing",
                "Infecter un réseau avec un virus",
                "Une attaque DoS vise à surcharger un système avec un excès de demandes pour le rendre inutilisable."
        ));

        questionsList.add(new Questions(
                "Comment pouvez-vous sécuriser votre réseau Wi-Fi domestique ?",
                "En utilisant un mot de passe fort et en activant le cryptage WPA2",
                "En laissant le réseau ouvert",
                "En utilisant un nom de réseau par défaut",
                "En désactivant le pare-feu",
                "Un mot de passe fort et le cryptage WPA2 augmentent la sécurité du réseau Wi-Fi contre les accès non autorisés."
        ));

        questionsList.add(new Questions(
                "Quelle est la meilleure façon de réagir face à un e-mail suspect au travail ?",
                "Alerter l'équipe de sécurité informatique de votre entreprise",
                "Ouvrir les pièces jointes pour enquêter",
                "Ignorer l'e-mail",
                "Répondre à l'expéditeur pour plus d'informations",
                "Signaler l'e-mail suspect à l'équipe de sécurité permet une réponse appropriée pour protéger l'entreprise."
        ));

        questionsList.add(new Questions(
                "Pourquoi est-il important de mettre à jour régulièrement vos logiciels et systèmes d'exploitation ?",
                "Pour corriger les failles de sécurité et améliorer les fonctionnalités",
                "Pour changer l'interface utilisateur",
                "Pour utiliser plus de ressources système",
                "Pour compatibilité avec les anciens logiciels",
                "Les mises à jour corrigent souvent des vulnérabilités de sécurité et apportent des améliorations importantes."
        ));

        questionsList.add(new Questions(
                "Qu'est-ce que le 'phishing' ciblé ou 'spear phishing' ?",
                "Une attaque de phishing dirigée vers un individu ou une organisation spécifique",
                "Un type de logiciel antivirus",
                "Une méthode pour sécuriser les e-mails",
                "Un outil de diagnostic réseau",
                "Le 'spear phishing' est plus ciblé que le phishing général et souvent plus trompeur et dangereux."
        ));

        questionsList.add(new Questions(
                "Qu'est-ce qu'un pare-feu ?",
                "Un système de sécurité qui surveille et contrôle le trafic réseau entrant et sortant",
                "Un programme pour supprimer les virus",
                "Un outil pour tester la vitesse de l'Internet",
                "Une fonctionnalité pour améliorer le Wi-Fi",
                "Les pare-feu sont essentiels pour établir une barrière entre votre réseau interne sécurisé et le trafic Internet non sécurisé."
        ));

        questionsList.add(new Questions(
                "Quel est le risque principal de l'utilisation de réseaux Wi-Fi publics ?",
                "La vulnérabilité à l'interception de données",
                "La vitesse de connexion lente",
                "L'incompatibilité avec certains appareils",
                "La limitation de la quantité de données transférables",
                "Les réseaux Wi-Fi publics ne sont pas sécurisés, rendant les données transmises vulnérables à l'interception."
        ));

        questionsList.add(new Questions(
                "Quelle méthode un attaquant pourrait-il utiliser pour deviner un mot de passe ?",
                "La force brute",
                "Le phishing",
                "Le spam",
                "Le partage de réseau",
                "La force brute consiste à essayer de nombreuses combinaisons pour deviner un mot de passe."
        ));

        questionsList.add(new Questions(
                "Qu'est-ce qu'un 'ransomware' ?",
                "Un type de malware qui crypte les fichiers de la victime et demande une rançon pour les décrypter",
                "Un logiciel de sécurité",
                "Une technique de sauvegarde des données",
                "Un type de pare-feu",
                "Les ransomwares sont une menace croissante, verrouillant les fichiers des victimes et exigeant souvent des paiements pour les récupérer."
        ));

        questionsList.add(new Questions(
                "Comment identifier un site Web sécurisé ?",
                "Rechercher 'https' et un symbole de cadenas dans la barre d'adresse",
                "Vérifier si le site a beaucoup de publicités",
                "Se fier uniquement aux avis des utilisateurs",
                "Choisir des sites avec des designs attractifs",
                "Le 'https' et le cadenas indiquent que le site utilise le cryptage pour sécuriser la communication entre votre navigateur et le site."
        ));

        questionsList.add(new Questions(
                "Qu'est-ce que l'ingénierie sociale en matière de cybersécurité ?",
                "Manipuler les gens pour qu'ils divulguent des informations confidentielles",
                "Développer des logiciels de sécurité",
                "Construire des infrastructures réseau",
                "Créer des bases de données sécurisées",
                "L'ingénierie sociale implique l'exploitation de la nature humaine pour obtenir des informations sensibles, plutôt que d'utiliser des méthodes techniques."
        ));

        questionsList.add(new Questions(
                "Pourquoi est-il important de sauvegarder régulièrement vos données ?",
                "Pour protéger contre la perte de données en cas de panne matérielle ou d'attaque de malware",
                "Pour économiser de l'espace sur l'appareil",
                "Pour améliorer la vitesse de l'ordinateur",
                "Pour réduire le risque de virus",
                "Les sauvegardes régulières assurent que vous avez des copies de vos données en cas de problèmes inattendus avec votre système."
        ));

        questionsList.add(new Questions(
                "Qu'est-ce qu'un 'zero-day exploit' ?",
                "Une faille de sécurité inconnue des développeurs du logiciel",
                "Une technique de récupération de données",
                "Un outil de surveillance réseau",
                "Un type de logiciel antivirus",
                "Les exploits 'zero-day' sont particulièrement dangereux car ils sont exploités avant que les développeurs ne soient au courant et puissent corriger la faille."
        ));

        questionsList.add(new Questions(
                "Quel est le but principal d'une politique de sécurité informatique en entreprise ?",
                "Protéger les informations et les actifs informatiques de l'entreprise",
                "Surveiller l'activité des employés",
                "Restreindre l'utilisation d'Internet",
                "Augmenter la productivité",
                "Une politique de sécurité informatique définit les règles et les procédures pour maintenir la sécurité des informations de l'entreprise."
        ));

        questionsList.add(new Questions(
                "Pourquoi est-il déconseillé d'utiliser des clés USB trouvées ou reçues de sources inconnues ?",
                "Elles peuvent contenir des logiciels malveillants",
                "Elles ont généralement une faible capacité de stockage",
                "Elles sont souvent défectueuses",
                "Elles peuvent ralentir l'ordinateur",
                "Les clés USB inconnues peuvent être intentionnellement infectées avec des logiciels malveillants pour compromettre votre ordinateur ou votre réseau."
        ));

        return questionsList;
    }

}
