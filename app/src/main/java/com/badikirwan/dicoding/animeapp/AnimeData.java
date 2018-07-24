package com.badikirwan.dicoding.animeapp;

import java.util.ArrayList;

public class AnimeData {

    public static String[][] data = new String[][] {
            {
                "Zoids",
                "https://image.tmdb.org/t/p/w154/wIE2yaeevcpgPGuHhIrkhNCvGiT.jpg",
                "67",
                "Zoids adalah mesin tempur seperti binatang yang digunakan baik dalam penggunaan sehari-hari seperti transportasi, dan penggunaan khusus seperti perang. Beberapa jenis Zoids, dikenal sebagai Organoids, adalah Zoids miniatur yang merupakan organisme hidup. Organoids ini memiliki kemampuan untuk menyatu dengan Zoid yang tidak hidup dan membuatnya jauh lebih kuat.",
                "250 view"
            },
            {
                "Mobile Suit Gundam Seed",
                "https://image.tmdb.org/t/p/w154/mEYEpwdRqYmT6g07yJaQmykTCsf.jpg",
                "50",
                "Cosmic Era 73, representatif ORB Union Cagalli Yula Athha beserta Athrun Zala (yang menggunakan nama samaran Alex Dino) mengunjungi pangkalan militer milik ZAFT Armory One. Di sana sedang dikembangkan 3 buah prototipe mobile suit, masing-masing adalah ZGMF-X24S Chaos Gundam, ZGMF-X31S Abyss Gundam, dan ZGMF-X88S Gaia Gundam. Cagalli dan Athrun mengunjungi Armory One dan bertemu dengan Perdana Menteri PLANT sekaligus pemimpin ZAFT Gilbert Durandal, membicarakan kerjasama bidang teknologi militer antara ORB dan ZAFT.",
                "300 view"
            },
            {
                "Bleach",
                "https://image.tmdb.org/t/p/w154/3RUtEMburuZkk1fbD1nS3bYrJPh.jpg",
                "366",
                "chigo Kurosaki adalah seorang siswa sekolah menengah biasa-sampai keluarganya diserang oleh Hollow, roh korup yang berusaha melahap jiwa manusia. Saat itulah ia bertemu dengan Soul Reaper bernama Rukia Kuchiki, yang terluka saat melindungi keluarga Ichigo dari penyerang. Untuk menyelamatkan keluarganya, Ichigo menerima tawaran Rukia untuk mengambil kekuatannya dan menjadi Soul Reaper sebagai hasilnya.",
                "470 view"
            },
            {
                "InuYasha",
                "https://img.topddl.net/images/f6635cf12ad942dac17a0da15dd4bbb9.th.jpg",
                "167",
                "Cerita berawal dari seorang Hanyo (manusia setengah siluman) bernama Inuyasha yang menginginkan kekuatan Bola Shikon no Tama (Bola Empat Arwah), agar bisa berubah menjadi siluman seutuhnya. Tentu saja bola Shikon no Tama ini bukanlah bola sembarangan, melainkan bola suci yang dijaga oleh seorang Miko (Seorang Pendeta) bernama Kikyo. Inuyasha mencoba mengambil bola tersebut dari tangan Kikyo, kontan itu membuat Kikyo beram dan menyegel Inuyasha di pohon keramat.",
                "230 view"
            }
    };

    public static ArrayList<AnimeModel> getListData() {
        AnimeModel animeModel;
        ArrayList<AnimeModel> list = new ArrayList<>();

        for (String[] aData : data) {
            animeModel = new AnimeModel();
            animeModel.setName(aData[0]);
            animeModel.setPhoto(aData[1]);
            animeModel.setEpisode(aData[2]);
            animeModel.setDeskripsi(aData[3]);
            animeModel.setViewAnime(aData[4]);
            list.add(animeModel);
        }

        return list;
    }
}
