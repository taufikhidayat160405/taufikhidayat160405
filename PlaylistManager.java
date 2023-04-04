import java.util.Scanner;

public class PlaylistManager {

    private static final int MAX_SONGS = 100; // jumlah maksimum lagu di playlist
    private final String[] playlist = new String[MAX_SONGS]; // array untuk menyimpan playlist lagu
    private int top = -1; // indeks atas tumpukan

    public static void main(String[] args) {
        PlaylistManager playlistManager = new PlaylistManager();
        playlistManager.run();
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            
            do {
                System.out.println("=== Playlist Manager ===");
                System.out.println("1. Tampilkan Data Playlist");
                System.out.println("2. Tambah Data Playlist");
                System.out.println("3. Hapus Data Playlist");
                System.out.println("4. Tambah Data Playlist di Urutan Tertentu");
                System.out.println("5. Hapus Data Playlist di Urutan Tertentu");
                System.out.println("6. Hapus Semua Playlist");
                System.out.println("0. Keluar");
                System.out.print("Pilihan Anda: ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1 :
                        displayPlaylist();
                    break;
                    case 2 :
                        addSong(scanner);
                    break;
                    case 3 :
                        removeSong(scanner);
                    break;
                    case 4 :
                        addSongAtIndex(scanner);
                    break;
                    case 5 :
                        removeSongAtIndex(scanner);
                    break;
                    case 6 :
                        removeAllSongs();
                    break;
                    case 0 :
                        System.out.println("Terima kasih telah menggunakan Playlist Manager!");
                    default :
                        System.out.println("Pilihan tidak valid!");
                }
                
            } while (choice != 0);
        }
    }

    public void displayPlaylist() {
        if (top == -1) {
            System.out.println("Playlist kosong!");
        } else {
            System.out.println("=== Daftar Lagu ===");
            for (int i = top; i >= 0; i--) {
                System.out.println((top - i + 1) + ". " + playlist[i]);
            }
        }
    }

    public void addSong(Scanner scanner) {
        if (top == MAX_SONGS - 1) {
            System.out.println("Playlist sudah penuh!");
        } else {
            System.out.print("Masukkan judul lagu: ");
            String title = scanner.next();
            top++;
            playlist[top] = title;
            System.out.println(title + " telah ditambahkan ke playlist.");
        }
    }

    public void removeSong(Scanner scanner) {
        if (top == -1) {
            System.out.println("Playlist kosong!");
        } else {
            System.out.print("Masukkan judul lagu yang akan dihapus: ");
            String title = scanner.next();
            int index = -1;
            for (int i = top; i >= 0; i--) {
                if (playlist[i].equals(title)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println(title + " tidak ditemukan di playlist!");
            } else {
                for (int i = index; i < top; i++) {
                    playlist[i] = playlist[i + 1];
                }
                top--;
                System.out.println(title + " telah dihapus dari playlist.");
            }
        }
    }

public void addSongAtIndex(Scanner scanner) {
    if (top == MAX_SONGS - 1) {
        System.out.println("Playlist sudah penuh!");
    } else {
        System.out.print("Masukkan judul lagu: ");
        String title = scanner.next();
        System.out.print("Masukkan posisi lagu (1 - " + (top + 2) + "): ");
        int index = scanner.nextInt() - 1;
        if (index < 0 || index > top + 1) {
            System.out.println("Posisi tidak valid!");
        } else {
            for (int i = top; i >= index; i--) {
                playlist[i + 1] = playlist[i];
            }
            top++;
            playlist[index] = title;
            System.out.println(title + " telah ditambahkan ke playlist pada posisi " + (index + 1) + ".");
        }
    }
}

public void removeSongAtIndex(Scanner scanner) {
    if (top == -1) {
        System.out.println("Playlist kosong!");
    } else {
        System.out.print("Masukkan posisi lagu yang akan dihapus (1 - " + (top + 1) + "): ");
        int index = scanner.nextInt() - 1;
        if (index < 0 || index > top) {
            System.out.println("Posisi tidak valid!");
        } else {
            String title = playlist[index];
            for (int i = index; i < top; i++) {
                playlist[i] = playlist[i + 1];
            }
            top--;
            System.out.println(title + " telah dihapus dari playlist pada posisi " + (index + 1) + ".");
        }
    }
}

public void removeAllSongs() {
    if (top == -1) {
        System.out.println("Playlist kosong!");
    } else {
        top = -1;
        System.out.println("Semua lagu telah dihapus dari playlist.");
    }
}
}




