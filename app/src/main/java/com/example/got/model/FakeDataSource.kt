package com.example.got.model

import com.example.got.R

object FakeDataSource {
    val dummyCharacters = listOf(
        Character("Eddard Stark", "Lord of Winterfell", "Sean Bean", "Male", "Stark", R.drawable.ned,"Lord Eddard Stark, also known as Ned Stark, was the head of House Stark, the Lord of Winterfell and Warden of the North, and later Hand of the King to King Robert I Baratheon. He was the older brother of Benjen, Lyanna and the younger brother of Brandon Stark. He is the father of Robb, Sansa, Arya, Bran, and Rickon by his wife, Catelyn Tully, and uncle of Jon Snow, who he raised as his bastard son. He was a dedicated husband and father, a loyal friend, and an honorable lord."),
        Character("Catelyn Stark", "Cat", "Michelle Fairley", "Female", "Stark", R.drawable.catelyn,"Lady Catelyn Stark, née Tully, was born into House Tully as the daughter of Hoster Tully, the Lord Paramount of the Trident, and sister of Lysa and Edmure Tully. She was the wife of Eddard Stark and the mother of his five children."),
        Character("Robb Stark", "The Wolf Pup", "Richard Madden", "Male", "Stark", R.drawable.robb,"Robb was the eldest child of Lady Catelyn and Lord Eddard Stark.[11] Robb was born at Riverrun and raised at Winterfell. His father left his mother the morning after their wedding to fight in Robert's Rebellion and did not return until after Robb was born. Robb Stark was likely named after Robert Baratheon.[citation needed] He had two younger trueborn brothers, Bran and Rickon, and two sisters, Sansa and Arya.[2]"),
        Character("Sansa Stark", "Little bird", "Sophie Turner", "Female", "Stark", R.drawable.sansa,"Queen Sansa Stark is the eldest daughter of Lord Eddard Stark and his wife, Lady Catelyn, sister of Robb, Arya, Bran, and Rickon Stark, and \"half-sister\" of Jon Snow; though truthfully is his cousin. Initially betrothed to Prince Joffrey Baratheon, the heir to the Iron Throne, Sansa travels to King's Landing in preparation for her nuptials, but essentially becomes a hostage of House Lannister following the execution of her father on trumped-up charges of treason. Under the (sometimes unwitting) tutelage of Cersei Lannister, Margaery Tyrell, and Petyr Baelish, Sansa becomes well-versed in politics and court intrigue, but suffers all the same.") ,
        Character("Arya Stark", "Many-Faced", "Maisie Williams", "Female", "Stark", R.drawable.arya,"Princess Arya Stark is the third child and second daughter of Lord Eddard Stark and his wife, Lady Catelyn Stark. She is the sister of the incumbent Westerosi monarchs, Sansa, Queen in the North, and Brandon, King of the Andals and the First Men. After narrowly escaping the persecution of House Stark by House Lannister, Arya is trained as a Faceless Man at the House of Black and White in Braavos, using her abilities to avenge her family. Upon her return to Westeros, she exacts retribution for the Red Wedding by exterminating the Frey male line."),
        Character("Bran Stark", "The Three-Eyed Raven", "Isaac Hempstead Wright", "Male", "Stark", R.drawable.bran,"King Bran I the Broken, born Brandon Stark and commonly known simply as \"Bran,\" is the fourth child and second son of Eddard and Catelyn Stark. Bran is a warg and a greenseer serving as the new Three-Eyed Raven. Eventually, he was crowned as the first elected ruler of the Six Kingdoms, styled as Bran the Broken, the First of His Name, King of the Andals and the First Men, Lord of the Six Kingdoms, and Protector of the Realm."),

        Character("Aerys II Targaryen", "The Mad King", "David Rintoul", "Male", "Targaryen", R.drawable.aerys,"King Aerys II Targaryen,[N 2] commonly called the Mad King, was the sixteenth member of House Targaryen to rule from the Iron Throne. Although his rule began benevolently, he succumbed to the madness caused by his incestuous lineage, and was eventually deposed by Lord Robert Baratheon in a civil war."),
        Character("Rhaegar Targaryen", "The Last Dragon", "Wilf Scolding", "Male", "Targaryen", R.drawable.rhaegar,"Prince Rhaegar Targaryen, the last Prince of Dragonstone, was the eldest son and heir to King Aerys II Targaryen, the Mad King. He was the older brother of Viserys and Daenerys Targaryen and the husband of Elia Martell, with whom he had two children, Rhaenys and Aegon. He also fathered Jon Snow with Lyanna Stark, whom he secretly married following an annulment from Elia."),
        Character("Viserys Targaryen", "The Dragon", "Harry Lloyd", "Male", "Targaryen", R.drawable.viserys,"Viserys Targaryen[N 4] was the younger brother of the late Rhaegar Targaryen, the older brother of Daenerys Targaryen and the uncle of Jon Snow. Viserys and Daenerys were the remnants of the exiled House Targaryen following a rebellion against their father, Aerys II Targaryen, the \"Mad King.\" He claimed the Iron Throne as King Viserys III following his father's murder, but never returned to Westeros, as he was killed by his brother-in-law, Khal Drogo, before he could make any attempt to take the throne."),
        Character("Daenerys Targaryen", "The Dragon Queen", "Emilia Clarke", "Female", "Targaryen", R.drawable.daenerys,"Queen Daenerys I Targaryen,[N 2] also known as Daenerys Stormborn, and affectionately known as Dany, was the only daughter of King Aerys II Targaryen and Queen Rhaella, and the younger sister of Rhaegar and Viserys Targaryen. Daenerys was initially a timid, obedient youth. After her marriage to Drogo she gathered the confidence of his khalasar. Following his death, she expanded her dominion into Essos, gaining the loyalty of an army of Unsullied and liberating Slaver's Bay from the Ghiscari slave masters."),
        Character("Jon Snow", "The Bastard of Winterfell", "Kit Harington", "Male", "Targaryen", R.drawable.jon,"Jon Snow, born Aegon Targaryen,[N 2] is the son of Lyanna Stark and Rhaegar Targaryen, the late Prince of Dragonstone. From infancy, Jon is presented as the bastard son of Lord Eddard Stark, Lyanna's brother, and raised alongside Eddard's lawful children at Winterfell. Jon's true parentage is kept secret from everyone, including Jon himself, in order to protect him from those that sought the complete annihilation of House Targaryen."),

        Character("Robert Baratheon", "alias", "cast", "Male", "Baratheon", R.drawable.ned,"detail"),
        Character("Stannis Baratheon", "alias", "cast", "Male", "Baratheon", R.drawable.ned,"detail"),
        Character("Renly Baratheon", "alias", "cast", "Male", "Baratheon", R.drawable.ned,"detail"),
        Character("Shireen Baratheon", "alias", "cast", "Male", "Baratheon", R.drawable.ned,"detail"),
        Character("Joffrey Baratheon", "alias", "cast", "Male", "Baratheon", R.drawable.ned,"detail"),

        Character("Tywin Lannister", "alias", "cast", "Male", "Lannister", R.drawable.ned,"detail"),
        Character("Jaime Lannister", "alias", "cast", "Male", "Lannister", R.drawable.ned,"detail"),
        Character("Cersei Lannister", "alias", "cast", "Male", "Lannister", R.drawable.ned,"detail"),
        Character("Tyrion Lannister", "alias", "cast", "Male", "Lannister", R.drawable.ned,"detail"),

        Character("Doran Martell", "alias", "cast", "Male", "Martell", R.drawable.ned,"detail"),
        Character("Oberyn Martell", "alias", "cast", "Male", "Martell", R.drawable.ned,"detail"),
        Character("Trystane Martell", "alias", "cast", "Male", "Martell", R.drawable.ned,"detail"),
        Character("Sand Snakes", "alias", "cast", "Male", "Martell", R.drawable.ned,"detail"),

        Character("Olenna Tyrell", "alias", "cast", "Male", "Tyrell", R.drawable.ned,"detail"),
        Character("Mace Tyrell", "alias", "cast", "Male", "Tyrell", R.drawable.ned,"detail"),
        Character("Margaery Tyrell", "alias", "cast", "Male", "Tyrell", R.drawable.ned,"detail"),
        Character("Loras Tyrell", "alias", "cast", "Male", "Tyrell", R.drawable.ned,"detail"),
    )
}